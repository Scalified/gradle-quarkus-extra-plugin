/*
 * MIT License
 *
 * Copyright (c) 2023 Scalified
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.scalified.plugins.gradle.quarkus.extra

import io.quarkus.gradle.QuarkusPlugin
import io.quarkus.gradle.tasks.QuarkusDev
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.internal.FileUtils
import org.gradle.kotlin.dsl.create
import org.gradle.kotlin.dsl.withType
import org.slf4j.LoggerFactory

/**
 * @author shell
 * @since 2023-12-16
 */
class QuarkusExtraPlugin : Plugin<Project> {

    private val logger = LoggerFactory.getLogger(QuarkusExtraPlugin::class.java)

    override fun apply(project: Project) {
        project.plugins.withType<QuarkusPlugin> {
            val extension = project.extensions.create<QuarkusExtraExtension>(QUARKUS_EXTRA).apply {
                logger.debug("'$QUARKUS_EXTRA' extension created")
                defaultProfile.convention(QuarkusProfileProperty.DEFAULT_VALUE)
                configDir.convention(project.rootDir.resolve(DEFAULT_CONFIG_DIR))
                configFileName.convention(DEFAULT_CONFIG_FILE_NAME)
                logger.debug("'$QUARKUS_EXTRA' extension configured")
            }
            val profile = System.getenv(QuarkusProfileProperty.ENV_KEY)
                ?: System.getProperty(QuarkusProfileProperty.ARG_KEY, extension.defaultProfile.get())
            project.tasks.withType<QuarkusDev>().configureEach {
                CONFIG_FILE_EXTENSIONS.map { ext ->
                    val fileNamePrefix = FileUtils.removeExtension(extension.configFileName.get())
                    val fileName = "${fileNamePrefix}${if (profile.isBlank()) "" else "-$profile"}.$ext"
                    extension.configDir.get().resolve(fileName)
                }.find { it.exists() }?.let { file ->
                    logger.debug("Found '${file.absolutePath}' quarkus configuration file")
                    environmentVariables.put(QUARKUS_CONFIG_LOCATIONS_PROPERTY_KEY, file.toURI().toString())
                    logger.info("Added '${file.absolutePath}' to Quarkus config locations")
                }
            }
        }
    }

}

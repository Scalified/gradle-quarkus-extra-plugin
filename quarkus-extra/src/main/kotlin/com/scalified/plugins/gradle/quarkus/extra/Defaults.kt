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

/**
 * @author shell
 * @since 2023-12-16
 */
internal const val QUARKUS_EXTRA = "quarkusExtra"

internal const val QUARKUS_CONFIG_LOCATIONS_PROPERTY_KEY = "QUARKUS_CONFIG_LOCATIONS"

internal const val DEFAULT_CONFIG_DIR = "config"

internal const val DEFAULT_CONFIG_FILE_NAME = "application"

internal val CONFIG_FILE_EXTENSIONS = setOf("properties", "yml", "yaml")

internal object QuarkusProfileProperty {
    const val ENV_KEY = "QUARKUS_PROFILE"
    const val ARG_KEY = "quarkus.profile"
    const val DEFAULT_VALUE = "local"
}

/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package dev.benjamin.pado

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.annotation.VisibleForTesting
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import dev.benjamin.pado.data.PetRepository
import dev.benjamin.pado.ui.DetailsScreen
import dev.benjamin.pado.ui.theme.PadoTheme

private const val KEY_ARG_DETAILS_PET_ID = "KEY_ARG_DETAILS_PET_ID"

fun launchDetailsActivity(context: Context, petId: Long) {
    context.startActivity(createDetailsActivityIntent(context, petId))
}

@VisibleForTesting
fun createDetailsActivityIntent(context: Context, petId: Long): Intent {
    val intent = Intent(context, DetailsActivity::class.java)
    intent.putExtra(KEY_ARG_DETAILS_PET_ID, petId)
    return intent
}

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PadoTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    PetRepository.getPets()
                        .find { pet ->
                            pet.id == intent.getLongExtra(KEY_ARG_DETAILS_PET_ID, -1)
                        }?.let { pet ->
                            DetailsScreen(pet, onBack = { finish() })
                        }
                }
            }
        }
    }
}

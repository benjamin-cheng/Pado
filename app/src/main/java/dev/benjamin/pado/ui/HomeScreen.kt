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
package dev.benjamin.pado.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.benjamin.pado.data.PetRepository
import dev.benjamin.pado.model.Pet
import dev.benjamin.pado.ui.theme.PadoTheme

@Composable
fun HomeScreen(
    pets: List<Pet>,
    navigateTo: (Screen) -> Unit
) {
    PetList(pets, navigateTo)
}

@Composable
private fun PetList(
    pets: List<Pet>,
    navigateTo: (Screen) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        items(pets) { pet ->
            PetCardSimple(pet, navigateTo)
        }
    }
}

@Composable
private fun PetListDivider() {
    Divider(
        modifier = Modifier.padding(horizontal = 14.dp),
        color = MaterialTheme.colors.onSurface.copy(alpha = 0.08f)
    )
}

@Preview("Pet List")
@Composable
fun PetListPreview() {
    PadoTheme {
        PetList(PetRepository.getPets(), {})
    }
}

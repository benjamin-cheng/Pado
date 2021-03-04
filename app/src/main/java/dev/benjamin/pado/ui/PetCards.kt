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

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.benjamin.pado.data.PetRepository
import dev.benjamin.pado.model.Pet
import dev.benjamin.pado.ui.theme.PadoTheme

@Composable
fun PetCardSimple(
    pet: Pet,
    navigateTo: (Screen) -> Unit,
) {
    Row(
        modifier = Modifier
            .clickable(onClick = { navigateTo(Screen.Detail(pet.id)) })
            .padding(16.dp)
    ) {
        PetImage(pet, Modifier.padding(end = 16.dp))
        Column(modifier = Modifier.weight(1f)) {
            PetName(pet)
            PetShortDescription(pet)
        }
    }
}

@Composable
fun PetImage(pet: Pet, modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(pet.imageId),
        contentDescription = null, // decorative
        modifier = modifier
            .size(40.dp, 40.dp)
            .clip(MaterialTheme.shapes.small)
    )
}

@Composable
fun PetName(pet: Pet) {
    Text(pet.name, style = MaterialTheme.typography.subtitle1)
}

@Composable
fun PetShortDescription(pet: Pet) {
    Text(pet.age + " - " + pet.breed, style = MaterialTheme.typography.body2)
}

@Preview("Pet card")
@Composable
fun SimplePostPreview() {
    PadoTheme {
        PetCardSimple(PetRepository.Lila) {}
    }
}

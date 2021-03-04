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
package dev.benjamin.pado.data

import dev.benjamin.pado.R
import dev.benjamin.pado.model.Pet

class PetRepository {

    companion object {
        fun getPets(): List<Pet> {
            return listOf(Lila, Catzilla, Roberta, Hawaii, Raiderette, Sugar)
        }

        val Lila = Pet(
            0L,
            "Lila",
            "Senior",
            "Female",
            "Domestic Medium Hair Mix",
            "Health\n" +
                "Vaccinations up to date, spayed / neutered.\n",
            R.drawable.lila,
        )

        val Catzilla = Pet(
            1L,
            "Catzilla",
            "Adult",
            "Female",
            "Domestic Short Hair Mix",
            "Health\n" +
                "Vaccinations up to date, spayed / neutered.\n",
            R.drawable.catzilla,
        )

        val Roberta = Pet(
            2L,
            "Roberta",
            "Senior",
            "Female",
            "Domestic Short Hair Mix",
            "Health\n" +
                "Vaccinations up to date, spayed / neutered.\n",
            R.drawable.roberta,
        )

        val Hawaii = Pet(
            3L,
            "Hawaii",
            "Young",
            "Male",
            "Domestic Short Hair Mix",
            "Health\n" +
                "Vaccinations up to date, spayed / neutered.\n",
            R.drawable.hawaii,
        )

        val Raiderette = Pet(
            4L,
            "Raiderette",
            "Adult",
            "Female",
            "Domestic Long Hair",
            "Characteristics\n" +
                "Apartment appropriate, Indoor only, No other cats please \n" +
                "\n" +
                "Health\n" +
                "Vaccinations up to date, spayed / neutered.\n",
            R.drawable.raiderette,
        )

        val Sugar = Pet(
            5L,
            "Sugar",
            "Adult",
            "Female",
            "Domestic Short Hair",
            "Characteristics\n" +
                "Affectionate, Apartment appropriate, Indoor only \n" +
                "\n" +
                "Health\n" +
                "Vaccinations up to date, spayed / neutered.\n",
            R.drawable.sugar,
        )
    }
}

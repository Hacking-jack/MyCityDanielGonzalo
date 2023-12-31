package com.example.mycity.data

import com.example.mycity.R

object Datasource {

    private val restaurantsCategory = Category(
        name = R.string.cafeterias,
        icon = R.drawable.restaurant_icon,
        list = listOf(
            Place(
                name = R.string.golda,
                description = R.string.golda_desc,
                address = R.string.golda_dir,
                photo = R.drawable.golda
            ),
            Place(
                name = R.string.salon_des_fleurs,
                description = R.string.salon_des_fleurs_desc,
                address = R.string.salon_des_fleurs_dir,
                photo = R.drawable.salon_des_fleurs
            ),
            Place(
                name = R.string.cofi,
                description = R.string.cofi_desc,
                address = R.string.cofi_dir,
                photo = R.drawable.cofi
            ),
            Place(
                name = R.string.cafe_del_art,
                description = R.string.cafe_del_art_desc,
                address = R.string.cafe_del_art_dir,
                photo = R.drawable.cafe_del_art
            )
        )
    )

    private val barsCategory = Category(
        name = R.string.restaurantes,
        icon = R.drawable.bar_icon,
        list = listOf(
            Place(
                name = R.string.charrua,
                description = R.string.charrua_desc,
                address = R.string.charrua_dir,
                photo = R.drawable.charrua
            ),
            Place(
                name = R.string.aarde,
                description = R.string.aarde_desc,
                address = R.string.aarde_dir,
                photo = R.drawable.aarde
            )
        )
    )
    private val parksCategory=Category(
        name=R.string.parques,
        icon = R.drawable.nature_icon,
        list=listOf(
            Place(
                name = R.string.retiro,
                description = R.string.retiro_desc,
                address = R.string.retiro_dir,
                photo = R.drawable.retiro
            ),
            Place(
                name = R.string.casa_campo,
                description = R.string.casa_campo_desc,
                address = R.string.casa_campo_dir,
                photo = R.drawable.casa_campo
            )
        )
    )
    private val shopsCategory=Category(
        name=R.string.centrosComerciales,
        icon=R.drawable.shops_icon,
        list = listOf(
            Place(
                name = R.string.xanadu,
                description = R.string.xanadu_desc,
                address = R.string.xanadu_dir,
                photo = R.drawable.xanadu
            ),
            Place(
                name = R.string.vaguada,
                description = R.string.vaguada_desc,
                address = R.string.vaguada_dir,
                photo = R.drawable.vaguada
            ),
            Place(
                name = R.string.islazul,
                description = R.string.islazul_desc,
                address = R.string.islazul_dir,
                photo = R.drawable.islazul
            )
        )
    )

    private val attractionsCategory= Category(
        name = R.string.lugaresParaNinios,
        icon = R.drawable.attractions_icon,
        list = listOf(
            Place(
                name = R.string.giraluna,
                description = R.string.giraluna_desc,
                address = R.string.giraluna_dir,
                photo = R.drawable.giraluna
            ),
            Place(
                name = R.string.ilusiona_diversia,
                description = R.string.ilusiona_diversia_desc,
                address = R.string.ilusiona_diversia_dir,
                photo = R.drawable.ilusiona_diversia
            ),
            Place(
                name = R.string.bosque_encantado,
                description = R.string.bosque_encantado_desc,
                address = R.string.bosque_encantado_dir,
                photo = R.drawable.bosque_encantado
            ),
            Place(
                name = R.string.casa_raton,
                description = R.string.casa_raton_desc,
                address = R.string.casa_raton_dir,
                photo = R.drawable.casa_raton
            )
        )

    )
    val listOfCategories = listOf(restaurantsCategory, barsCategory, parksCategory, shopsCategory, attractionsCategory)

}
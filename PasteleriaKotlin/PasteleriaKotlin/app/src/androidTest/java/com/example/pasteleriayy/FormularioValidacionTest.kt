package com.example.pasteleriayy

import android.app.Activity
import androidx.activity.ComponentActivity
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.navigation.NavController
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.pasteleriayy.ui.screens.FormularioValidacion
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FormularioValidacionInstrumentedTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>(ComponentActivity::class.java)
    @Test
    fun topBarShowsTitle() {
        val activity = composeTestRule.activity
        val nav = NavController(activity)
        composeTestRule.setContent {
            FormularioValidacion(navController = nav)
        }
        composeTestRule.onNodeWithText("Registro de Usuario").assertExists()
    }

   @Test
    fun mismatchedPasswordsShowsErrorMessage() {
        val activity = composeTestRule.activity
        val nav = NavController(activity)
        composeTestRule.setContent {
            FormularioValidacion(navController = nav)
        }
        composeTestRule.onNodeWithText("Contraseña").performTextInput("abc123")
        composeTestRule.onNodeWithText("Confirmar Contraseña").performTextInput("diff")
        composeTestRule.onNodeWithText("Registrar Usuario").performClick()
        composeTestRule.onNodeWithText("Las contraseñas no coinciden").assertExists()
    }

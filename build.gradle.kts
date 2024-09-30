// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
}

// Este archivo no debería incluir repositorios de nuevo, ya que ya se han definido en settings.gradle.kts

// Puedes agregar otras configuraciones globales aquí si es necesario
allprojects {
    // No es necesario agregar aquí el repositorio de Google ni Maven Central nuevamente
}

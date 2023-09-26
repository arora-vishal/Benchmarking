package com.ixigo.demo.benchmark

import androidx.benchmark.macro.BaselineProfileMode
import androidx.benchmark.macro.CompilationMode
import androidx.benchmark.macro.StartupMode
import androidx.benchmark.macro.StartupTimingMetric
import androidx.benchmark.macro.junit4.MacrobenchmarkRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ExampleStartupBenchmark {
    @get:Rule
    val benchmarkRule = MacrobenchmarkRule()

    @Test
    fun benchmarkAppStartup() {
        benchmarkRule.measureRepeated(
            packageName = "com.ixigo.demo",
            compilationMode = CompilationMode.None(),
            metrics = listOf(StartupTimingMetric()),
            iterations = 5,
            startupMode = StartupMode.COLD,
            setupBlock = {
                killProcess()
                pressHome()
            }
        ) {
            startActivityAndWait()
        }
    }

    @Test
    fun benchmarkBaselineProfile() {
        benchmarkRule.measureRepeated(
            packageName = "com.ixigo.demo",
            compilationMode = CompilationMode.Partial(baselineProfileMode = BaselineProfileMode.Require),
            metrics = listOf(StartupTimingMetric()),
            iterations = 5,
            startupMode = StartupMode.COLD,
            setupBlock = {
                killProcess()
                pressHome()
            }
        ) {
            startActivityAndWait()
        }
    }
}
package com.dewarder.akommons.binding.dimen

import android.content.res.Resources
import android.support.test.rule.ActivityTestRule
import com.dewarder.akommons.binding.TestActivity
import com.dewarder.akommons.binding.common.dimen.BaseDimenTest
import com.dewarder.akommons.binding.common.dimen.TestableDimen
import org.junit.Rule

class FragmentDimenTest : BaseDimenTest() {

    class Activity : TestActivity() {
        override fun initFragment() = TestDimenFragment()
    }

    @get:Rule
    val activityRule = ActivityTestRule<Activity>(Activity::class.java)

    override fun getTestableDimen(): TestableDimen = activityRule.activity.getFragment()

    override fun getResources(): Resources = activityRule.activity.resources
}
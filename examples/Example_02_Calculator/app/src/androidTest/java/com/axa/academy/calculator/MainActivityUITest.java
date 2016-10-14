package com.axa.academy.calculator;

import android.support.test.espresso.NoMatchingViewException;
import android.support.test.espresso.ViewAssertion;
import android.support.test.rule.ActivityTestRule;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.axa.academy.calculator.utils.ToastMatcher;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


public class MainActivityUITest {

    // Do not use string.xml labels, we are testing them.
    private final static String SCREEN_TITLE = "Example_02_Calculator";
    private final static String INPUT_HINT = "0";
    private final static String RESULT = "Result: ";
    private final static String INPUT_ERROR = "Input Error";

    @Rule
    public ActivityTestRule<MainActivity> activityRule =
            new ActivityTestRule<>(MainActivity.class);

    private MainActivity activity;
    private UtilsHelper mockedUtilsHelper;

    @BeforeClass
    public static void setUpBeforeClass() {
        // Runs before tests execution, example: initialization of resources
    }

    @AfterClass
    public static void tearDownAfterClass() {
        // Runs after all test are executed, example: closing resources
    }

    @Before
    public void setUp() {
        // Execution before each test method, example: test isolation
        activity = activityRule.getActivity();
        mockedUtilsHelper = mock(UtilsHelper.class);
    }

    @After
    public void tearDown() {
        // Execution after each test method
        if (activity != null) {
            activity.finish();
            activity = null;
        }
    }

    @Test
    public void testPreconditions() {
        assertNotNull(activity.findViewById(R.id.btnAdd));
        assertNotNull(activity.findViewById(R.id.btnSubstract));
        assertNotNull(activity.findViewById(R.id.tvResult));
        assertNotNull(activity.findViewById(R.id.etFirst));
        assertNotNull(activity.findViewById(R.id.etSecond));
    }

    @Test
    public void testDefaults() {
        assertEquals(SCREEN_TITLE, activity.getTitle());
        assertEquals(RESULT, ((TextView)activity.findViewById(R.id.tvResult)).getText());
        assertEquals(INPUT_HINT, ((EditText)activity.findViewById(R.id.etFirst)).getHint());
        assertEquals(INPUT_HINT, ((EditText)activity.findViewById(R.id.etSecond)).getHint());
    }

    @Test
    public void testAddUpdatesResult() {
        onView(withId(R.id.etFirst))
                .perform(click())
                .perform(typeText("1"));
        onView(withId(R.id.etSecond))
                .perform(click())
                .perform(typeText("1"));
        onView(withId(R.id.btnAdd)).perform(click());
        onView(withId(R.id.tvResult)).check(new ViewAssertion() {
            @Override
            public void check(View view, NoMatchingViewException noViewFoundException) {
                TextView aux = (TextView) view;
                aux.getText().toString().contentEquals(RESULT.concat("2"));
            }
        });
    }

    @Test
    public void testSubstractUpdatesResult() {
        onView(withId(R.id.etFirst))
                .perform(click())
                .perform(typeText("3"));
        onView(withId(R.id.etSecond))
                .perform(click())
                .perform(typeText("1"));
        onView(withId(R.id.btnSubstract)).perform(click());
        onView(withId(R.id.tvResult)).check(new ViewAssertion() {
            @Override
            public void check(View view, NoMatchingViewException noViewFoundException) {
                TextView aux = (TextView) view;
                aux.getText().toString().contentEquals(RESULT.concat("2"));
            }
        });
    }

    @Test
    public void testAddEmptyShowsError() {
        onView(withId(R.id.btnAdd)).perform(click());
        onView(withText(INPUT_ERROR)).inRoot(new ToastMatcher()).check(matches(isDisplayed()));
    }

    @Test
    public void testSubstractEmptyShowsError() {
        onView(withId(R.id.btnSubstract)).perform(click());
        onView(withText(INPUT_ERROR)).inRoot(new ToastMatcher()).check(matches(isDisplayed()));
    }

    @Test
    public void testAddResultClosesKeyboard() {
        // Espresso can not check directly if keyboard is displayed
        // We check if 'closeKeyboard' was called
        activity.setUtilsHelper(mockedUtilsHelper);
        onView(withId(R.id.etFirst))
                .perform(click())
                .perform(typeText("3"));
        onView(withId(R.id.etSecond))
                .perform(click())
                .perform(typeText("1"));
        onView(withId(R.id.btnAdd)).perform(click());
        verify(mockedUtilsHelper, times(1)).closeKeyboard(activity);
    }

    @Test
    public void testSubstractResultClosesKeyboard() {
        // Espresso can not check directly if keyboard is displayed
        // We check if 'closeKeyboard' was called
        activity.setUtilsHelper(mockedUtilsHelper);
        onView(withId(R.id.etFirst))
                .perform(click())
                .perform(typeText("3"));
        onView(withId(R.id.etSecond))
                .perform(click())
                .perform(typeText("1"));
        onView(withId(R.id.btnSubstract)).perform(click());
        verify(mockedUtilsHelper, times(1)).closeKeyboard(activity);
    }

}

$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("forgot_password1.feature");
formatter.feature({
  "comments": [
    {
      "line": 2,
      "value": "#Author: jay.franklin@csra.com"
    }
  ],
  "line": 5,
  "name": "resend_verification_email",
  "description": "As a user who is unable to remember their password.\r\nI need a way to have the email re-sent to me so that I can \r\nactivate my account password and continue with my registration.",
  "id": "resend-verification-email",
  "keyword": "Feature",
  "tags": [
    {
      "line": 4,
      "name": "@all_faa"
    },
    {
      "line": 4,
      "name": "@jay_group2"
    },
    {
      "line": 4,
      "name": "@forgot_password"
    },
    {
      "line": 4,
      "name": "@update_nonhobbyist"
    },
    {
      "line": 4,
      "name": "@forgot_password1.feature"
    }
  ]
});
formatter.scenario({
  "line": 9,
  "name": "1 - Forgot Password Test -- 11 Steps",
  "description": "",
  "id": "resend-verification-email;1---forgot-password-test----11-steps",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 10,
  "name": "i have accessed the welcome page",
  "keyword": "Given "
});
formatter.step({
  "line": 11,
  "name": "i click on the Login button",
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "i click on the I Agree button",
  "keyword": "Then "
});
formatter.step({
  "line": 13,
  "name": "i click the forgot password link",
  "keyword": "Then "
});
formatter.step({
  "line": 14,
  "name": "i type email address from forgot password page",
  "keyword": "Then "
});
formatter.step({
  "line": 15,
  "name": "i click the send button",
  "keyword": "Then "
});
formatter.match({
  "location": "NavigationMap.given_welcome()"
});
formatter.result({
  "duration": 16190849226,
  "status": "passed"
});
formatter.match({
  "location": "NavigationMap.when_click_login_button()"
});
formatter.result({
  "duration": 1907947846,
  "status": "passed"
});
formatter.match({
  "location": "NavigationMap.clickOnIAgreeButton()"
});
formatter.result({
  "duration": 3519716441,
  "status": "passed"
});
formatter.match({
  "location": "NavigationMap.clickOnForgotPasswordLink()"
});
formatter.result({
  "duration": 4865453310,
  "status": "passed"
});
formatter.match({
  "location": "NavigationMap.typeIntoForgotPasswordEmailField()"
});
formatter.result({
  "duration": 997962469,
  "status": "passed"
});
formatter.match({
  "location": "NavigationMap.clickOnSendEmailButton()"
});
formatter.result({
  "duration": 548255268,
  "status": "passed"
});
formatter.uri("forgot_password2.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: jay.franklin@csra.com"
    }
  ],
  "line": 4,
  "name": "forgot_password",
  "description": "User Story [UAS-133][UAS-661]\r\nAs a user who is unable to remember their password.\r\nI need a way to have the email re-sent to me so that I can \r\nactivate my account password and continue with my registration.",
  "id": "forgot-password",
  "keyword": "Feature",
  "tags": [
    {
      "line": 3,
      "name": "@all_faa"
    },
    {
      "line": 3,
      "name": "@jay_group2"
    },
    {
      "line": 3,
      "name": "@forgot_password"
    },
    {
      "line": 3,
      "name": "@update_nonhobbyist"
    },
    {
      "line": 3,
      "name": "@forgot_password2.feature"
    }
  ]
});
formatter.scenario({
  "line": 10,
  "name": "2 - Forgot Password Test -- 12 Steps",
  "description": "",
  "id": "forgot-password;2---forgot-password-test----12-steps",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 11,
  "name": "i have accessed the gmail login page",
  "keyword": "Given "
});
formatter.step({
  "line": 12,
  "name": "i log on using newly created email address",
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "i enter my gmail password \u0027Dummy$11\u0027",
  "keyword": "Then "
});
formatter.step({
  "line": 14,
  "name": "i click on the gmail inbox",
  "keyword": "Then "
});
formatter.step({
  "line": 15,
  "name": "i click on inbox message Forgot your password",
  "keyword": "Then "
});
formatter.step({
  "line": 16,
  "name": "i click email message to reset password",
  "keyword": "Then "
});
formatter.match({
  "location": "NavigationMap.gmail_login()"
});
formatter.result({
  "duration": 5943006685,
  "status": "passed"
});
formatter.match({
  "location": "NavigationMap.when_i_enter_gmail_email_address()"
});
formatter.result({
  "duration": 2132254355,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Dummy$11",
      "offset": 27
    }
  ],
  "location": "NavigationMap.when_i_enter_gmail_password(String)"
});
formatter.result({
  "duration": 10087502293,
  "status": "passed"
});
formatter.match({
  "location": "NavigationMap.click_on_gmail_inbox()"
});
formatter.result({
  "duration": 1682058076,
  "status": "passed"
});
formatter.match({
  "location": "NavigationMap.click_inbox_gmail_message_forgot_your_password()"
});
formatter.result({
  "duration": 11131506011,
  "status": "passed"
});
formatter.match({
  "location": "NavigationMap.gmailClickToResetPassword()"
});
formatter.result({
  "duration": 12223867410,
  "status": "passed"
});
});
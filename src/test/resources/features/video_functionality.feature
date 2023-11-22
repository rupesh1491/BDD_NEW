Feature: Verify the video player functionality
  @video
  Scenario: Verify video player functionality
    Given I am on the Daily Mail Video Page
    And I click on a video to begin playback
    And I click the video to pause playback
    And I click the forward arrow
    And I click the back arrow
    And I click on the speaker icon to mute the video
    And I click on the speaker icon again to unmute the video
    And I verify next video autoplay after current video finishes
Feature: Is it over 20?
        Everybody wants to relax at 20

        Scenario Outline: Time is or is not over 20
        Given time is "<time>"
        When I ask whether it's over 20
        Then I should be told "<answer>"

        Examples:
        | time            | answer |
        | Friday         | relax   |
        | Sunday         | Nope   |
        | anything else! | Nope   |
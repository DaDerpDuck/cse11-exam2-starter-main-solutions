// EXAM INSTRUCTIONS:
// All of your code for Task 2 goes in this file.
// Add new method headers and implementations as appropriate to these classes
// Add examples to the ExamplesTweets class.
import tester.*;

interface Tweet {
    // Task 2.1: mostPopularAuthorOnThread
    // Your code here
    User mostPopularAuthorOnThread();

    // Task 2.2: shortestTweetOnThread
    // Your code here
    Tweet shortestTweetOnThread();

    // Provided methods, DO NOT MODIFY
    User getAuthor();
    String getContents();
    int getLikes();
    Tweet getReplyTo();
}

// User class, DO NOT MODIFY
class User {
    String username, displayName;
    int followers;
    User(String username, String displayName, int followers) {
        this.username = username;
        this.displayName = displayName;
        this.followers = followers;
    }

    String toText() {
        return username + " @" + displayName;
    }
}

class TextTweet implements Tweet {
    User author;
    String contents;
    int likes;
    TextTweet(String contents, User author, int likes) {
        this.author = author;
        this.contents = contents;
        this.likes = likes;
    }

    // Task 2.1: mostPopularAuthorOnThread
    // Your code here
    public User mostPopularAuthorOnThread() {
        return author;
    }

    // Task 2.2: shortestTweetOnThread
    // Your code here
    public Tweet shortestTweetOnThread() {
        return this;
    }
    

    // Provided methods, DO NOT MODIFY
    public User getAuthor() {
        return author;
    }

    public String getContents() {
        return contents;
    }

    public int getLikes() {
        return likes;
    }

    public Tweet getReplyTo() {
        return null;
    }

}

class ReplyTweet implements Tweet {
    User author;
    String contents;
    int likes;
    Tweet replyTo;
    ReplyTweet(String contents, User author, int likes, Tweet replyTo) {
        this.author = author;
        this.contents = contents;
        this.likes = likes;
        this.replyTo = replyTo;
    }

    // Task 2.1: mostPopularAuthorOnThread
    // Your code here
    public User mostPopularAuthorOnThread() {
        Tweet mostPopularTweet = this;
        Tweet currentTweet = this;

        while (currentTweet.getReplyTo() != null) {
            currentTweet = currentTweet.getReplyTo();
            if (currentTweet.getLikes() > mostPopularTweet.getLikes())
                mostPopularTweet = currentTweet;
        }

        return mostPopularTweet.getAuthor();
    }


    // Task 2.2: shortestTweetOnThread
    // Your code here
    public Tweet shortestTweetOnThread() {
        Tweet shortestTweet = this;
        Tweet currentTweet = this;

        while (currentTweet.getReplyTo() != null) {
            currentTweet = currentTweet.getReplyTo();
            if (currentTweet.getContents().length() < shortestTweet.getContents().length())
                shortestTweet = currentTweet;
        }

        return shortestTweet;
    }

    // Provided methods, DO NOT MODIFY
    public User getAuthor() {
        return author;
    }

    public String getContents() {
        return contents;
    }

    public int getLikes() {
        return likes;
    }

    public Tweet getReplyTo() {
        return replyTo;
    }
}

class ExampleTweets {
    // Video Task
    // Your code here
}
    
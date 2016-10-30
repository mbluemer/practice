Comments = new Mongo.Collection("comments");

Meteor.methods({
   commentInsert: function(commentAttributes) {
     check(this.userId, String);
     check(commentAttributes, {
       body: String,
       postId: String
     });

     var user = Meteor.user();
     var post = Posts.findOne(commentAttributes.postId);

     if (!post)
      throw new Meteor.Error('invalid-comment', 'You must comment on a post');

    comment = _.extend(commentAttributes, {
      userId: user._id,
      author: user.username,
      submitted: new Date()
    });

    // update the post with the number of comments
    Posts.update(comment.postId, {$inc: {commentsCount: 1}});

    // create the comment and save the id
    comment._id = Comments.insert(comment);

    // Now create the notification to inform the poster
    createCommentNotification(comment);

    return comment._id;
  }
});
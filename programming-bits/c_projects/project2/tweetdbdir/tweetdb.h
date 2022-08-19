/* 
 * Author: Carlos López 
 * Date: 18/08/22
 * Description: This is the header file for the tweet database
 */
#ifndef _TWEET_DB_
#define _TWEET_DB_

struct tweetdb{
  char username[40];
  char date[9];
  char tweet[241];
};

#endif /* _TWEET_DB_

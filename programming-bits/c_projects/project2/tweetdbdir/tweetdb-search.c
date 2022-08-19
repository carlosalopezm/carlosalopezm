/* 
 * Author: Carlos López 
 * Date: 08/18/22
 * Description: this C file is used to search for Tweets in a database of
 * tweets. 
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "linkedlist.h"
#include "tweetdb.h"
void printNodeVals(char *lookUp, struct List *lst);
void mdbLL(struct List *lst, FILE *fp);
void removeAllNodesTweetDB(struct List *lst);
int main(int argc, char **argv){
	if(argc != 2)
		exit(1);
	else{
		FILE *fp = fopen(argv[1], "r");
		if(fp == NULL)
			exit(1);
		struct List listTweetDb;
		initList(&listTweetDB);
		tweetdbLL(&listTweetDB, fp);
		char keyW[43];
		char buff[1001];
    // Here is the prompt for the user to enter a string to access one of the
    // tweets based on three criteria: username, date, or 42 characters of
    // a tweet
		printf("Enter a char/string  (it truncates to 42): ");
		while(fgets(buff, 1001, stdin)!=NULL){
			strncpy(keyW,buff, 42);
			if(strlen(buff)>42) {
		         	keyW[42]	= '\0';
			} else{
				keyW[strlen(buff)-1]= '\0';
			}
			printNodeVals(keyW, &listTweetDB);
			printf("Enter a char/string  or string (it truncates to 5): ");
	}
	removeAllNodesTweetDB(&listTweetDB);
	  fclose(fp);
	  return 0;
	}
}
void tweedbLL(struct List *lst, FILE *fp){
	struct tweetdb  buff;
	struct Node *prev = NULL;
	while(fread(&buff, sizeof(struct tweetdb),1, fp )){
			struct tweetdb  *newTweetDB = (struct tweetdb *)malloc(sizeof(struct tweetdb)); // here a total of 290 bytes are allocated
			if(newTweetDB != NULL){
				strncpy(newTweetDB->username, buff.username, 40);
        strncpy(newTweetDB->date, buff.date, 9);
				strncpy(newTweetDB->tweet, buff.tweet, 241);
		       	prev = addAfter(lst,prev,newTweetDB);
		}

	}
}
void printNodeVals(char *lookUp, struct List *lst){
	int i = 0;
       	struct Node *curr = lst->head;
	while(curr){
		i++;
		struct tweetdb  *tmpRec= (struct tweetdb *)curr->data;
		if(strstr(((struct tweetdb *)(curr->data))->username, lookUp)!= NULL || strstr(((struct tweetdb *)(curr->data))->date, lookUp) || strstr(((struct tweetdb  *)(curr->data))->tweet, lookUp)!=NULL)
			printf("%d: {%s} said {%s}\n", i, tmpRec->username, tmprec->date,  tmpRec->tweet); // change the format to the way in which it was written in tweetdb-add
		curr = curr->next;
	}
	printf("\n");
}
void removeAllNodesMDB(struct List *lst){
	struct Node *curr = lst->head;
	while(curr){
		free(((struct MdbRec *)(curr->data)));
		lst->head = curr->next;
		curr->next = NULL;
		free(curr);
		curr = lst->head;
	}
}


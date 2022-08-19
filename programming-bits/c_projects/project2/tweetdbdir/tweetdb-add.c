/*
 * Author: Carlos López 
 * Date: 08/18/22
 * Description: This is the c program used to add tweets
 */
/*
 * mdb-add.c
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

//#include "linkedlist.h"
#include "tweetdb.h"

static void die(const char *message) {
    perror(message);
    exit(1);
}

static void sanitize(char *s) {
    while (*s) {
        if (!isprint(*s))
            *s = ' ';
        s++;
    }
}

int main(int argc, char **argv)
{
    /*
     * open the database file specified in the command line
     */

    if (argc != 3) {
        fprintf(stderr, "%s\n", "usage: tweet-add <database_file>");
        exit(1);
    }

    char *filename = argv[1];
    // open for append & read, in binary mode
    FILE *fp = fopen(filename, "a+b");
    if (fp == NULL) {
        die(filename);
    }

    /*
     * load the database file into a linked list
     */

    struct List list;
    initList(&list);

    // we need to call fseek() to read from the beginning
    fseek(fp, 0, SEEK_SET);

    int loaded = loadmdb(fp, &list);
    if (loaded < 0)
        die("loadmdb");

    // count the number of entries and keep a pointer to the last node
    struct Node *lastNode = list.head;
    int recNo = 0;
    while (lastNode) {
        recNo++;
        if (lastNode->next) {
            lastNode = lastNode->next;
        } else {
            break;
        }
    }

    /*
     * read name
     */

    struct tweetdb  r;
    char line[1000];

    printf("name please (will truncate to %d chars): ", (int)sizeof(r.name)-1);
    if (fgets(line, sizeof(line), stdin) == NULL) {
        fprintf(stderr, "%s\n", "could not read name");
        exit(1);
    }
    // must null-terminate the string manually after strncpy().
    strncpy(r.name, line, sizeof(r.name) - 1);
    r.name[sizeof(r.name) - 1] = '\0';
    // if newline is there, remove it.
    size_t last = strlen(r.name) - 1;
    if (r.name[last] == '\n')
        r.name[last] = '\0';

    /*
     * read date
     *
     */
 
    printf("date please (will truncate to %d chars and the format is MM/DD/YY): ", (int)sizeof(r.msg)-1);
    if (fgets(line, sizeof(line), stdin) == NULL) {
        fprintf(stderr, "%s\n", "could not read msg");
        exit(1);
    }
    // must null-terminate the string manually after strncpy().
    strncpy(r.date, line, sizeof(r.date) - 1);
    r.date[sizeof(r.date) - 1] = '\0';
    // if newline is there, remove it.
    last = strlen(r.date) - 1;
    if (r.date[last] == '\n')
        r.date[last] = '\0';



    /*
     * read tweet
     */

    printf("tweet please (will truncate to %d chars): ", (int)sizeof(r.msg)-1);
    if (fgets(line, sizeof(line), stdin) == NULL) {
        fprintf(stderr, "%s\n", "could not read msg");
        exit(1);
    }
    // must null-terminate the string manually after strncpy().
    strncpy(r.tweet, line, sizeof(r.tweet) - 1);
    r.tweet[sizeof(r.tweet) - 1] = '\0';
    // if newline is there, remove it.
    last = strlen(r.tweet) - 1;
    if (r.tweet[last] == '\n')
        r.tweet[last] = '\0';

    /*
     * add the record to the in-memory database
     */

    struct tweetdb  *rec = (struct tweetdb  *)malloc(sizeof(r));
    if (!rec)
        die("malloc failed");
    memcpy(rec, &r, sizeof(r));
    struct Node *newNode = addAfter(&list, lastNode, rec);
    if (newNode == NULL)
        die("addAfter() failed");
    recNo++;

    /*
     * write the name, date, and tweet  to the database file
     */

    // remove non-printable chars from the strings
    sanitize(r.name);
    sanitize(r.date);
    sanitize(r.tweet);

    if (fwrite(&r, sizeof(r), 1, fp) < 1) {
        perror("can't write record");
        exit(1);
    }
    if (fflush(fp) != 0) {
        perror("can't write to file");
        exit(1);
    }

    /*
     * print confirmation
     */

    printf("*********************************** •  \n %4d: @{%s} \n • Date: {%s} \n • Tweet:  {%s} \n *********************************** \n", recNo, rec->name, rec-> date, rec->tweet);
    fflush(stdout);

    /*
     * clean up and exit
     */

    freemdb(&list);
    fclose(fp);
    return 0;
}

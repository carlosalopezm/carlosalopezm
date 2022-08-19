# COMS 3134 - Data Structures in Java

## Homework 0: Hello World

### Step 1: Compiling and running a program. 

You will notice a file called `HelloWorld.java` in your workspace.  Click on it to open it in the editor and view the code.

When you are ready to try running it, click on the **Tools** menu and select **Terminal**.  
Every codio project is essentially its own virtual machine running Ubuntu linux. 

From the terminal type:

```ls```

This will show you a list of files in your directory.  It should include the `README.md` (this file) and `HelloWorld.java`.  Next from the terminal type:

```javac HelloWorld.java```

This will compile your code down to a byte code that can be executed by the computer.  From the terminal type:

```ls```

again and you will see an additional file called `HelloWorld.class`.  This is your byte code. To execute it, from the terminal type:

```java HelloWorld```

 
### Step 2: Try more terminal commands.
If you are unfamiliar with the Unix/Linux shell, here are a few things to try. Of you already know your way around the shell/terminal feel free to skip this step. 

* Print the path name of the current working directory.
```
$ pwd
/home/codio/workspace
```

* Create a new directory 
```
$ mkdir test
$ ls
HelloWorld.class  HelloWorld.java  README.md  test
```

* Navigate to a different directory (relative from the current path)
```
$ cd test
$ pwd
/home/codio/workspace/test
```
Your home directory has the alias ~
```
$ cd ~
$ pwd
/home/codio
```
Note that you always want to work in the workspace, not in your home directory. 
```
$ cd workspace
$ pwd
/home/codio/workspace
```

* You can get more info about the files in this directory. 

```
$ ls -l
total 12
-rw-rw-r-- 1 codio codio  426 Sep  4 00:43 HelloWorld.class
-rw-r--r-- 1 codio codio  161 Sep  4 00:43 HelloWorld.java
-rw-r--r-- 1 codio codio 2620 Sep  4 00:47 README.md
drwxrwxr-x 1 codio codio    0 Sep  4 00:41 test
```

* Create a copy of a file

```
$ cp HelloWorld.java Hello2.java
```

* Move or rename a file

```
$ mv Hello2.java Hello3.java
$ ls
Hello3.java  HelloWorld.class  HelloWorld.java  README.md  test
```

* Remove a file. Warning: This will not ask for your confirmation. Once you run this command, the file is gone for good!

``` 
$ rm Hello3.java
$ rm -r test  # remove the directory test together with all its content
$ ls
HelloWorld.class  HelloWorld.java  README.md
```

For a more detailed introduction to the shell, take a look at http://linuxcommand.org/

### Step 3: Creating a new program.

Click on the **File** menu, and then on **New File...** to create a new file. Name it `GenericBinarySearch.java` and copy (or retype) the Binary Search code discussed in class. 
Run the program with a list of integers to make sure it works correctly. Then create a `ComparablePerson.java` file and copy (or retype) the code discussed in class (this represents a person with a first name and last name, that implements the Comparable interface).
Finally, modify the main program in `GenericBinarySearch.java` so that it operates on a list of at least three ComparablePerson instances. Make sure to import the ComparablePerson class from GenericBinarySearch.

Compile and run your program. You can compile multiple Java files in the same directory using `javac *.java`. Java will also automatically (re-)compile all imported classes when necessary. 

### Submitting Homework 0

Once you are done, with homework 0, please click on the **Education** menu and select **Mark as Complete**. You will only receive credit for this homework once it has been marked as complete. 
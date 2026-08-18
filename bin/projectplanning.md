Ignore if your name isn't Alper Diker

roadmap as of august 18

1. use ArrayList to store all accounts in bank
2. add a toString method to account, display all info except password
3. add an ID system using an initial randomized 9 digit number that gets incremented by one each time a new account is created
4. make sure that transactions require password and maybe id, undecided.
5. put a .checkPassword method in the account class not in bank class. only call it in bank class to check whether the user input matches it using a boolean return type.
6. require the other person's name and ID in the transfer money method
7. add a blocking system to avoid receiving money from undesirable people
8. add a transaction fee between 1-3%.
9. add either JSON file or SQL database later on with password encryption
10. add GUI using javaFX 

- - - - - - - -- - - -  -- - - - - - - - -
instruction on saving changes to github 

1. open terminal
2. cd(space) github repo link
3. git add .
4. git commit -m "message"
5. git push origin and then branch name

- - - - -- - - - - - - --  - - - -- - 

to create a new branch: git switch -c branchname

to confirm what branch: git branch

The first time you push a new branch you must tell GitHub its name: git push -u origin branchname

switch to main : git switch main
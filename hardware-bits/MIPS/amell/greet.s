.data
  message: .asciiz "\n Hello my name is Carlos Lopez. \n I suck at MIPS\n at the
  moment\n"

.text
main:
  jal displayGreeting

  li $v0, 10 #tells system to end the function call
  syscall 

displayGreeting:
  li $v0, 4 #4 tells te system to print strings 
  la $a0, message
  syscall 

  jr $ra 

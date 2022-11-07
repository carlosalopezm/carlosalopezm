.data

newline: .asciiz "\n"

.text

main:
  li $a1,  60
  li $a2, 9
  jal addTwo

  
  li $v0, 1
  add $a0, $v1, 0
  syscall



li $v0, 10
syscall 

addTwo:
  add $v1, $a1, $a2
  jr $ra

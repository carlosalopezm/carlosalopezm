.data
  newline: .asciiz "\n"

.text 

  main:
    addi $s0, $0, 32

    jal stackOp

    li $v0, 4
    la $a0, newline
    syscall

    li $v0, 1
    move $a0, $s0
    syscall

    li $v0, 4
    la $a0, newline
    syscall

    li $v0, 10
    syscall
  stackOp:
    addi $sp, $sp, -4 #-4 to free space
    sw $s0, 0($sp)
    addi $s0, $s0, 10
    li $v0, 1 #tell sys to print the val 
    move $a0, $s0
    syscall 
    #restore the value in the stack
    lw $s0, 0($sp)
    addi $sp, $sp, 4 #add 4 to stack

    jr $ra

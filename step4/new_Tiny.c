Tiny code
label main
move 1 a
move 2 b
move 10 c
move 20 d
sys writei a
sys writes newline
sys writei b
sys writes newline
sys writei c
sys writes newline
sys writei d
sys writes newline
addr a b 4
move 4 a
sys writei a
sys writes newline
mulr a c 6
move 6 b
sys writei b
sys writes newline
subr 0 a 8
addr 8 b 9
move 9 c
sys writei c
sys writes newline
subr 0 d 11
move 11 d
sys writei d
sys writes newline
addr a b 13
addr 13 c 14
addr 14 d 15
divr 15 a 16
move 16 a
sys writei a
sys writes newline
addi a 10 18
move 18 a
sys writei a
sys writes newline
addr b a 20
addi 20 10 21
move 21 b
sys writei b
sys writes newline
subi 0 10 23
move 23 c
sys writei c
sys writes newline
move 1.0 x
move 2.0 y
move 3.14159 z
sys writer x
sys writes newline
sys writer z
sys writes newline
sys writer y
sys writes newline
divr z 2.0 28
move 28 x
divr z y 30
move 30 y
sys writer x
sys writes newline
sys writer y
sys writes newline
addr x y 32
addr 32 z 33
divr 33 z 34
move 34 t
sys writer t
sys writes newline
mulr t t 36
move 36 t
sys writer t
sys writes newline
divr z 7.0 38
divr z 6.0 39
divr z 5.0 40
divr z 4.0 41
divr t 2.0 42
addr t z 43
addr 43 t 44
addr 44 42 45
addr 45 41 46
addr 46 40 47
addr 47 39 48
addr 48 38 49
move 49 t
sys writer t
sys writes newline
sys halt

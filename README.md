# Compiler-Java
This is a simple compiler written in Java, designed for learning compiler theory. It can compile arithmetic expressions into pseudo-assembly language.  
Run `Compiler.main()`, and Input arithmetic expressions in the console like:  
```
1+(5-3)*9/3;
end
```  
Then, you can get the  pseudo-assembly language complied from the arithmetic expressions above:  
```
t0 = 1
t1 = 5
t2 = 3
t1 -= t2
t2 = 9
t1 *= t2
t2 = 3
t1 /= t2
t0 += t1
```  

## Lexical Analysis
The process of converting a character sequence into a sequence of tokens.  
Examples in arithmetic expressions:    
```
1 → NUM_OR_ID
( → LP
) → RP
+ → PLUS
- → MINUS
* → TIMES
/ → DIVIDE
; → SEMI
```

## Parsing
A process that involves analyzing an input text consisting of a sequence of tokens based on a given formal grammar, and determining its syntactic structure.  
An example for this compiler:   
```
statements -> expression ; | expression ; statements
expression -> term expression'
expression' -> PLUS/MINUS term expression' | ''
term -> factor term'
term' -> *or/ factor term' | ''
factor -> NUM_OR_ID | LP expression RP
```  
For the arithmetic expression 1+2, we can obtain the following syntax analysis:  
![2024-02-04 114937](https://github.com/lirunsen/Compiler-Java/assets/82029821/8b9932a9-49f0-483e-821b-c78660592a7b)


## Create Pseudo-assembly Language
Generate assembly language suitable for execution by programmable devices such as CPU. The compiler in this project produces pseudo-assembly language.  
We can use an image to show an example of pseudo-assembly language generation of the arithmetic expressions `1+2*3+4` using this compiler:  
![2024-02-04 115006](https://github.com/lirunsen/Compiler-Java/assets/82029821/1ec8a912-4a28-4887-87eb-595794ee7555)

# Compiler-Java
This is a simple compiler written in Java, designed for learning compiler theory. It can compile arithmetic expressions into pseudo-assembly language.  
Run `Compiler.main()`, and Input arithmetic expressions in the console like:  
```1+(5-3)*9/3;
end
```  
Then, you can get the  pseudo-assembly language complied from the arithmetic expressions above:  
```t0 = 1
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
Example:

## Parsing
A process that involves analyzing an input text consisting of a sequence of tokens based on a given formal grammar, and determining its syntactic structure.  
Example:

## Create Pseudo-assembly Language
Generate assembly language suitable for execution by programmable devices such as CPU. The compiler in this project produces pseudo-assembly language.

.class public App
.super java/lang/Object

.field public static someField Ljava/lang/String;

.method public <init>()V
	aload_0                                      ; Loads "this" on the stack
	invokenonvirtual java/lang/Object/<init>()V  ; Call super constructor
	return                                       ; Terminate method
.end method

; Method definition for public static void main(String[] args)
.method public static main([Ljava/lang/String;)V
	.limit stack 100
	.limit locals 3
	ldc "jaaa!"
	putstatic App/someField Ljava/lang/String;
	ldc 9
	istore_0
	iconst_3
	istore_1
	ldc "nee :("
	putstatic App/someField Ljava/lang/String;
	getstatic java/lang/System.out Ljava/io/PrintStream;
	iload_0
	iload_1
	iadd
	ldc 6
	isub
	iconst_3
	isub
	iconst_4
	if_icmpge label1
	iconst_1
	goto label2
	label1:
	iconst_0
	label2:
	invokevirtual java/io/PrintStream/println(Z)V
	getstatic java/lang/System.out Ljava/io/PrintStream;
	iload_1
	invokevirtual java/io/PrintStream/println(I)V
	iconst_3
	iconst_3
	invokestatic App/someMethod(II)I
	istore_2
	getstatic java/lang/System.out Ljava/io/PrintStream;
	iload_2
	invokevirtual java/io/PrintStream/println(I)V
	return 
.end method

.method public static someMethod(II)I
	.limit stack 100
	.limit locals 2
	iload_0
	iload_1
	iadd
	ireturn 
.end method


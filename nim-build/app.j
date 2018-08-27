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
	.limit locals 6
	ldc "jaaa!"
	putstatic App/someField Ljava/lang/String;
	ldc 9
	istore_0
	iconst_3
	istore_1
	iload_1
	i2d 
	dstore_2
	new java/lang/StringBuilder
	dup
	invokespecial java/lang/StringBuilder/<init>()V
	ldc "een string "
	invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;
	dload_2
	invokevirtual java/lang/StringBuilder/append(D)Ljava/lang/StringBuilder;
	invokevirtual java/lang/StringBuilder.toString()Ljava/lang/String;
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
	getstatic App/someField Ljava/lang/String;
	invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
	iconst_3
	iconst_3
	invokestatic App/someMethod(II)I
	i2d 
	dstore 4
	getstatic java/lang/System.out Ljava/io/PrintStream;
	dload 4
	invokevirtual java/io/PrintStream/println(D)V
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


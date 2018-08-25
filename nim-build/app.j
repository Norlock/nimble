.class public App
.super java/lang/Object

.field public static test Ljava/lang/String;

.method public <init>()V
	aload_0                                      ; Loads "this" on the stack
	invokenonvirtual java/lang/Object/<init>()V  ; Call super constructor
	return                                       ; Terminate method
.end method

; Method definition for public static void main(String[] args)
.method public static main([Ljava/lang/String;)V
	.limit stack 100
	.limit locals 100

	ldc "jaaa!"
	putstatic App/test Ljava/lang/String;
	iconst_0
	istore_2
	iconst_3
	istore_3
	ldc "nee :("
	putstatic App/test Ljava/lang/String;
	iload_2
	iload_3
	if_icmpge label2
	ldc "ss"
	astore 4
	iconst_5
	istore_2
	getstatic java/lang/System.out Ljava/io/PrintStream;
	getstatic App/test Ljava/lang/String;
	invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
	goto label1
	label2:
	ldc "yes"
	astore 5
	label1:
	return
.end method

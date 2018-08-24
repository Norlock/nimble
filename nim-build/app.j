.class public App
    .super java/lang/Object

    ; Default constructor (empty constructor)
    .method public <init>()V
        aload_0                                     ; Loads "this" on the stack
        invokenonvirtual java/lang/Object/<init>()V ; Call super constructor
        return                                      ; Terminate method
    .end method
    
    ; Method definition for public static void main(String[] args)
    .method public static main([Ljava/lang/String;)V
        .limit stack 100
        .limit locals 100

		iconst_0
		istore_1
		iconst_3
		istore_2
		getstatic java/lang/System.out Ljava/io/PrintStream;
		iload_1
		invokevirtual java/io/PrintStream/println(I)V
		getstatic java/lang/System.out Ljava/io/PrintStream;
		iload_2
		invokevirtual java/io/PrintStream/println(I)V
		iload_1
		iload_2
		if_icmpge label2
		ldc "ss"
		astore_3
		iconst_5
		istore_1
		getstatic java/lang/System.out Ljava/io/PrintStream;
		new java/lang/StringBuilder
		dup
		invokespecial java/lang/StringBuilder/<init>()V
		iload_1
		invokevirtual java/lang/StringBuilder/append(I)Ljava/lang/StringBuilder;
		aload_3
		invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;
		invokevirtual java/lang/StringBuilder.toString()Ljava/lang/String;
		invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
		goto label1
		label2:
		ldc "yes"
		astore 4
		label1:
        return
    .end method

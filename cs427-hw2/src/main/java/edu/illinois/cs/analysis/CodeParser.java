package edu.illinois.cs.analysis;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

public class CodeParser extends VoidVisitorAdapter
{
	int methNum = 0;

	/**
	 * Following the visitor pattern design, this visit function will be
	 * automatically applied to all method declarations within the given
	 * compilation unit (i.e., Java files).
	 */
	@Override
	public void visit(MethodDeclaration n, Object arg) {
		super.visit(n, arg);
		
		// TODO: add your implementation here so that it counts the methods
		// satisfying the listed constriants rather than all possible methods
		if (n.getBody().isPresent() && !n.getParameters().isEmpty() && n.isPublic() && !n.isStatic() && !n.getType().isVoidType()) {
			methNum++;
		}		
	}

}

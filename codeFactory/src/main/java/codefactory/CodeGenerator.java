package codefactory;

import cn.org.rapid_framework.generator.GeneratorFacade;

public class CodeGenerator {

	public static void main(String[] args) throws Exception {
        //模板路径，需要指定磁盘绝对路径，
		String templatePath = "G:/gitPriCode/codeFactory/codeFactory/src/main/resources/template_top";
		GeneratorFacade g = new GeneratorFacade();
		g.getGenerator().addTemplateRootDir(templatePath);
		
		// 删除生成器的输出目录//
		// g.deleteOutRootDir();
		// 通过数据库表生成文件
		//g.generateByTable("subarea_decided_rela");//可以填入表名，多个表填多个参数
		g.generateByTable("top_jzjf_apply","top_jzjf_set_meal");//可以填入表名，多个表填多个参数

		// 自动搜索数据库中的所有表并生成文件,template为模板的根目录
		// g.generateByAllTable();
		
		// 按table名字删除文件
		// g.deleteByTable("table_name", "template");
	}

}

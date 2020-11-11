package Dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import Entity.Article;
import cn.itcast.jdbc.TxQueryRunner;

public class ArticleDao {
	private QueryRunner qr = new TxQueryRunner();
	//添加文章
	public boolean addArticleDao(Article article) {
		String sql = "insert into article(address,dno,head,part) values(?,?,?,?)";
		try {
			Object[] params = {article.getAddress(),article.getDno(),article.getHead(),article.getPart()};
			if (qr.update(sql,params)>0) {
				return true;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return false;
	}
	//更改文章
	public boolean updateArticleDao(Article article) {
		String sql = "update article set dno=?,head=?,part=? where address=?";
		try {
			Object[] params = {article.getDno(),article.getHead(),article.getPart(),article.getAddress()};
			if (qr.update(sql,params)>0) {
				return true;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return false;
	}
	//根据地址删除文章
	public boolean delArticleByAddDao(int address) {
		String sql = "delete from Article where address=?";
		try {
			if (qr.update(sql,address)>0) {
				return true;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return false;
	}
	
//	查询所有文章
	public List<Article> queryAllArticleDao() {
		String sql = "select * from article";
		try {
			return qr.query(sql, new BeanListHandler<Article>(Article.class));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	//根据分块查文章
		public List<Article> queryArticleByPartDao(String partstring) {
			String sql = "select * from article JOIN part USING(part) where partstring = ?";
			try {
				return qr.query(sql, new BeanListHandler<Article>(Article.class),partstring);
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	//根据医生查文章
	public List<Article> queryArticleByDnoDao(int dno) {
		String sql = "select * from article JOIN part USING(part) where dno = ?";
		try {
			return qr.query(sql, new BeanListHandler<Article>(Article.class),dno);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	//根据地址查
	public Article queryArticleByAddDao(int address) {
		String sql = "select * from article JOIN part USING(part) where address = ?";
		try {
			return qr.query(sql, new BeanHandler<Article>(Article.class),address);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	//根据医生标题查
	public Article queryArticleByAddDao(int dno,String header) {
		String sql = "select * from article where dno = ? and head = ?";
		Object parmas[] = {dno,header};
		try {
			return qr.query(sql, new BeanHandler<Article>(Article.class),parmas);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	//查询电话 文章是否存在
	public boolean isExist(int address) {
		return queryArticleByAddDao(address)==null? false:true;
	}
	public boolean isExist(int dno, String head) {
		return queryArticleByAddDao(dno, head)==null? false:true;
	}
}

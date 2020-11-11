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
	//�������
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
	//��������
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
	//���ݵ�ַɾ������
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
	
//	��ѯ��������
	public List<Article> queryAllArticleDao() {
		String sql = "select * from article";
		try {
			return qr.query(sql, new BeanListHandler<Article>(Article.class));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	//���ݷֿ������
		public List<Article> queryArticleByPartDao(String partstring) {
			String sql = "select * from article JOIN part USING(part) where partstring = ?";
			try {
				return qr.query(sql, new BeanListHandler<Article>(Article.class),partstring);
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	//����ҽ��������
	public List<Article> queryArticleByDnoDao(int dno) {
		String sql = "select * from article JOIN part USING(part) where dno = ?";
		try {
			return qr.query(sql, new BeanListHandler<Article>(Article.class),dno);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	//���ݵ�ַ��
	public Article queryArticleByAddDao(int address) {
		String sql = "select * from article JOIN part USING(part) where address = ?";
		try {
			return qr.query(sql, new BeanHandler<Article>(Article.class),address);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	//����ҽ�������
	public Article queryArticleByAddDao(int dno,String header) {
		String sql = "select * from article where dno = ? and head = ?";
		Object parmas[] = {dno,header};
		try {
			return qr.query(sql, new BeanHandler<Article>(Article.class),parmas);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	//��ѯ�绰 �����Ƿ����
	public boolean isExist(int address) {
		return queryArticleByAddDao(address)==null? false:true;
	}
	public boolean isExist(int dno, String head) {
		return queryArticleByAddDao(dno, head)==null? false:true;
	}
}

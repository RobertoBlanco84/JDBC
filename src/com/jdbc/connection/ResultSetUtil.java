package com.jdbc.connection;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.jdbc.java_bean.DeletedOwnerBean;
import com.jdbc.java_bean.DogBean;
import com.jdbc.java_bean.DogKeeperBean;
import com.jdbc.java_bean.NewOwnerBean;

public class ResultSetUtil {
	static DogBean dogBean = new DogBean();
	static DogKeeperBean dogKeeperBean = new DogKeeperBean();
	static NewOwnerBean newOwnerBean = new NewOwnerBean();
	static DeletedOwnerBean deletedOwnerBean = new DeletedOwnerBean();
	ResultSet resultSet;

	//SELECT display methods
	public static final ResultSet displayDogResult(ResultSet resultSet) {
		try {
			while (resultSet.next()) {
				for (int j = 0; j < 5 ; j++) {
					System.out.print(resultSet.getString(dogBean.getDogList().get(j)) + " ");
				}
				System.out.println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return resultSet;

	}

	public static final ResultSet displayDogKeeperResult(ResultSet resultSet) {
		try {
			while (resultSet.next()) {
				for (int j = 0; j < 3 ; j++) {
					System.out.print(resultSet.getString(dogKeeperBean.getKeeperList().get(j)) + " ");
				}
				System.out.println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return resultSet;
	}

	public static final ResultSet displayNewOwnerResult(ResultSet resultSet) {
		try {
			while (resultSet.next()) {
				for (int j = 0; j < 5 ; j++) {
					System.out.print(resultSet.getString(newOwnerBean.getNewOwnerList().get(j)) + " ");
				}
				System.out.println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return resultSet;
	}

	public static final ResultSet displayDeletedOwnerResult(ResultSet resultSet) {
		try {
			while (resultSet.next()) {
				for (int j = 0; j < 5 ; j++) {
					System.out.print(resultSet.getString(deletedOwnerBean.getDeletedOwnerList().get(j)) + " ");
				}
				System.out.println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return resultSet;
	}
	//END OF SELECT display methods
	public static final ResultSet displayInsertDogResult(ResultSet resultSet) {
		try {
			if(resultSet.last()) {
				for(String element : dogBean.getDogQueue()) {
					System.out.print(resultSet.getString(element.toString()) + " ");
				}
				System.out.println();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return resultSet;
	}

	public static final ResultSet displayInsertKeeperResult(ResultSet resultSet) {
		try {
			if(resultSet.last()) {
				for(String element : dogKeeperBean.getDogKeeperQueue()) {
					System.out.print(resultSet.getString(element.toString()) + " ");
				}
				System.out.println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return resultSet;
	}

	public static final ResultSet displayInsertNewOwnerResult(ResultSet resultSet) {
		try {
			if(resultSet.last()) {
				for(String element : newOwnerBean.getNewOwnerQueue()) {
					System.out.print(resultSet.getString(element.toString()) + " ");
				}
				System.out.println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return resultSet;
	}

	public static final ResultSet displaySearchtNewOwnerResult(ResultSet resultSet) {
		try {
			if(resultSet.next()) {
				for (int j = 0; j < 5; j++) {
					System.out.print(resultSet.getString(newOwnerBean.getNewOwnerList().get(j)) + " ");
				} 
				System.out.println();

			}
			else {
				System.out.println("Owner_id doesnt exist.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return resultSet;
	}
}

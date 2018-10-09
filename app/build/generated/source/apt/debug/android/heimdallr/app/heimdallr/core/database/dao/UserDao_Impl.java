package android.heimdallr.app.heimdallr.core.database.dao;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.arch.persistence.room.SharedSQLiteStatement;
import android.database.Cursor;
import android.heimdallr.app.heimdallr.core.database.models.User;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class UserDao_Impl implements UserDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfUser;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfUser;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public UserDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUser = new EntityInsertionAdapter<User>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `user`(`uid`,`name`,`phone`,`email`,`wallet`,`token`,`refreshToken`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, User value) {
        stmt.bindLong(1, value.getUid());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getPhone() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getPhone());
        }
        if (value.getEmail() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getEmail());
        }
        if (value.getWallet() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getWallet());
        }
        if (value.getToken() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getToken());
        }
        if (value.getRefreshToken() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getRefreshToken());
        }
      }
    };
    this.__deletionAdapterOfUser = new EntityDeletionOrUpdateAdapter<User>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `user` WHERE `uid` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, User value) {
        stmt.bindLong(1, value.getUid());
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM user";
        return _query;
      }
    };
  }

  @Override
  public void insertAll(User... users) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfUser.insert(users);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insert(User user) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfUser.insert(user);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(User user) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfUser.handle(user);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll() {
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAll.release(_stmt);
    }
  }

  @Override
  public List<User> getAll() {
    final String _sql = "SELECT * FROM user";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfUid = _cursor.getColumnIndexOrThrow("uid");
      final int _cursorIndexOfName = _cursor.getColumnIndexOrThrow("name");
      final int _cursorIndexOfPhone = _cursor.getColumnIndexOrThrow("phone");
      final int _cursorIndexOfEmail = _cursor.getColumnIndexOrThrow("email");
      final int _cursorIndexOfWallet = _cursor.getColumnIndexOrThrow("wallet");
      final int _cursorIndexOfToken = _cursor.getColumnIndexOrThrow("token");
      final int _cursorIndexOfRefreshToken = _cursor.getColumnIndexOrThrow("refreshToken");
      final List<User> _result = new ArrayList<User>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final User _item;
        _item = new User();
        final int _tmpUid;
        _tmpUid = _cursor.getInt(_cursorIndexOfUid);
        _item.setUid(_tmpUid);
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        _item.setName(_tmpName);
        final String _tmpPhone;
        _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
        _item.setPhone(_tmpPhone);
        final String _tmpEmail;
        _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
        _item.setEmail(_tmpEmail);
        final String _tmpWallet;
        _tmpWallet = _cursor.getString(_cursorIndexOfWallet);
        _item.setWallet(_tmpWallet);
        final String _tmpToken;
        _tmpToken = _cursor.getString(_cursorIndexOfToken);
        _item.setToken(_tmpToken);
        final String _tmpRefreshToken;
        _tmpRefreshToken = _cursor.getString(_cursorIndexOfRefreshToken);
        _item.setRefreshToken(_tmpRefreshToken);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public User getSingleUser() {
    final String _sql = "SELECT * FROM user LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfUid = _cursor.getColumnIndexOrThrow("uid");
      final int _cursorIndexOfName = _cursor.getColumnIndexOrThrow("name");
      final int _cursorIndexOfPhone = _cursor.getColumnIndexOrThrow("phone");
      final int _cursorIndexOfEmail = _cursor.getColumnIndexOrThrow("email");
      final int _cursorIndexOfWallet = _cursor.getColumnIndexOrThrow("wallet");
      final int _cursorIndexOfToken = _cursor.getColumnIndexOrThrow("token");
      final int _cursorIndexOfRefreshToken = _cursor.getColumnIndexOrThrow("refreshToken");
      final User _result;
      if(_cursor.moveToFirst()) {
        _result = new User();
        final int _tmpUid;
        _tmpUid = _cursor.getInt(_cursorIndexOfUid);
        _result.setUid(_tmpUid);
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        _result.setName(_tmpName);
        final String _tmpPhone;
        _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
        _result.setPhone(_tmpPhone);
        final String _tmpEmail;
        _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
        _result.setEmail(_tmpEmail);
        final String _tmpWallet;
        _tmpWallet = _cursor.getString(_cursorIndexOfWallet);
        _result.setWallet(_tmpWallet);
        final String _tmpToken;
        _tmpToken = _cursor.getString(_cursorIndexOfToken);
        _result.setToken(_tmpToken);
        final String _tmpRefreshToken;
        _tmpRefreshToken = _cursor.getString(_cursorIndexOfRefreshToken);
        _result.setRefreshToken(_tmpRefreshToken);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public User findByemail(String email) {
    final String _sql = "SELECT * FROM user WHERE email LIKE ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (email == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, email);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfUid = _cursor.getColumnIndexOrThrow("uid");
      final int _cursorIndexOfName = _cursor.getColumnIndexOrThrow("name");
      final int _cursorIndexOfPhone = _cursor.getColumnIndexOrThrow("phone");
      final int _cursorIndexOfEmail = _cursor.getColumnIndexOrThrow("email");
      final int _cursorIndexOfWallet = _cursor.getColumnIndexOrThrow("wallet");
      final int _cursorIndexOfToken = _cursor.getColumnIndexOrThrow("token");
      final int _cursorIndexOfRefreshToken = _cursor.getColumnIndexOrThrow("refreshToken");
      final User _result;
      if(_cursor.moveToFirst()) {
        _result = new User();
        final int _tmpUid;
        _tmpUid = _cursor.getInt(_cursorIndexOfUid);
        _result.setUid(_tmpUid);
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        _result.setName(_tmpName);
        final String _tmpPhone;
        _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
        _result.setPhone(_tmpPhone);
        final String _tmpEmail;
        _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
        _result.setEmail(_tmpEmail);
        final String _tmpWallet;
        _tmpWallet = _cursor.getString(_cursorIndexOfWallet);
        _result.setWallet(_tmpWallet);
        final String _tmpToken;
        _tmpToken = _cursor.getString(_cursorIndexOfToken);
        _result.setToken(_tmpToken);
        final String _tmpRefreshToken;
        _tmpRefreshToken = _cursor.getString(_cursorIndexOfRefreshToken);
        _result.setRefreshToken(_tmpRefreshToken);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public User findByphone(String phone) {
    final String _sql = "SELECT * FROM user WHERE email LIKE ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (phone == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, phone);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfUid = _cursor.getColumnIndexOrThrow("uid");
      final int _cursorIndexOfName = _cursor.getColumnIndexOrThrow("name");
      final int _cursorIndexOfPhone = _cursor.getColumnIndexOrThrow("phone");
      final int _cursorIndexOfEmail = _cursor.getColumnIndexOrThrow("email");
      final int _cursorIndexOfWallet = _cursor.getColumnIndexOrThrow("wallet");
      final int _cursorIndexOfToken = _cursor.getColumnIndexOrThrow("token");
      final int _cursorIndexOfRefreshToken = _cursor.getColumnIndexOrThrow("refreshToken");
      final User _result;
      if(_cursor.moveToFirst()) {
        _result = new User();
        final int _tmpUid;
        _tmpUid = _cursor.getInt(_cursorIndexOfUid);
        _result.setUid(_tmpUid);
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        _result.setName(_tmpName);
        final String _tmpPhone;
        _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
        _result.setPhone(_tmpPhone);
        final String _tmpEmail;
        _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
        _result.setEmail(_tmpEmail);
        final String _tmpWallet;
        _tmpWallet = _cursor.getString(_cursorIndexOfWallet);
        _result.setWallet(_tmpWallet);
        final String _tmpToken;
        _tmpToken = _cursor.getString(_cursorIndexOfToken);
        _result.setToken(_tmpToken);
        final String _tmpRefreshToken;
        _tmpRefreshToken = _cursor.getString(_cursorIndexOfRefreshToken);
        _result.setRefreshToken(_tmpRefreshToken);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public int countUsers() {
    final String _sql = "SELECT COUNT(*) from user";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getInt(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}

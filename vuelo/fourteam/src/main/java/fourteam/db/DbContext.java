package fourteam.db;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public abstract class DbContext implements IDbContext {

	private List<DbSet> _dbSets;
	private Class _dbContextClass;

	public DbContext(Class dbContextClass) {
		_dbContextClass = dbContextClass;
		_dbSets = new ArrayList<>();
		this.instanceDbSet();
		onModelCreating(_dbSets);
	}

	public List<Object> getDomainEvents() {
		List<Object> events = new ArrayList<>();
		for (DbSet dbSet : _dbSets) {
			events.addAll(dbSet.get_events());
		}
		return events;
	}

	public void instanceDbSet() {
		Field[] fields = _dbContextClass.getFields();
		for (Field field : fields) {
			if (field.getType().getName().contains(fourteam.db.DbSet.class.getName())) {
				try {
					DbSet db = new DbSet<>(this, field);
					field.set(this, db);
					_dbSets.add(db);
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

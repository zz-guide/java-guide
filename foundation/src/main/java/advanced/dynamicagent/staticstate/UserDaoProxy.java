package advanced.dynamicagent.staticstate;

import advanced.dynamicagent.dao.IUserDao;

public class UserDaoProxy implements IUserDao {

    private IUserDao target;

    public void setTarget(IUserDao target) {
        this.target = target;
    }

    @Override
    public void say() {
        System.out.println("----代理前----");
        target.say();
        System.out.println("----代理后----");
    }
}

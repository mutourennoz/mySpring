package com.raycloud.bean;

import org.springframework.beans.factory.FactoryBean;

public class ColorFactoryBean implements FactoryBean<Color> {
    /**
     * 返回一个Color对象
     *
     * @return
     * @throws Exception
     */
    @Override
    public Color getObject() throws Exception {
        return new Color();
    }

    @Override
    public Class<?> getObjectType() {
        System.out.println("ColorFactoryBean....");
        return null;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}

package com.dreamliner.dragrv.interfaces;

/**
 * @author chenzj
 * @Title: CallbackItemTouch
 * @Description: 类的描述 - 自定义item切换的接口
 * @date 2016/6/14 09:52
 * @email admin@chenzhongjin.cn
 */
public interface CallbackItemTouch {

    /**
     * Called when an item has been dragged
     *
     * @param oldPosition start position
     * @param newPosition end position
     */
    void itemTouchOnMove(int oldPosition, int newPosition);
}

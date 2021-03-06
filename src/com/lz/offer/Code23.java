package com.lz.offer;

/**
 * Created by Administrator on 2018/2/15.
 *
 * 题目：
 *设计一个栈，可以实现min函数的功能，并且保存push 和pop 和min 函数都是O(1)的时间复杂度
 *
 *  分析：
 *      題目限定push pop都是O(1)复杂度，那么就表明我们必须不能改变栈的特性，不然就无法满足了
 *      那么我们只能通过一些附加的空间来保存最小值，如果我们只使用一个变量来保存最小值，每次push都
 *      把通过比较把最小值赋值给变量，但是这样的问题是，如果我们pop后，把最小值pop的话，那我们就无法
 *      把次小值保存下来，显然不满足条件，
 *
 *    那么我们可以使用一个辅助栈，每次push的时候，就把当前最小值压入栈中，pop就弹出栈顶元素。
 *  这样就可以实现了min函数的栈
 */
public class Code23 {

}

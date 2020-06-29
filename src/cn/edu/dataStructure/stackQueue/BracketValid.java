package cn.edu.dataStructure.stackQueue;

import java.util.Stack;

/**
 * @auther NieBin
 * @create 2020-05-20 10:35
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 *     左括号必须用相同类型的右括号闭合。
 *     左括号必须以正确的顺序闭合。
 *
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 *
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 *
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 *
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 *
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 算法思想：用栈存储开括号，遇到闭括号就判断，如果成对就消失，不成对返回false；如果最后全部成对，那么栈中
 *          的闭括号全部消失，栈为空
 */
public class BracketValid {
    public boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c=='('||c=='['||c=='{'){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                boolean b1=(c==')'&&stack.pop()!='(');
                boolean b2=(c==']'&&stack.pop()!='[');
                boolean b3=(c=='}'&&stack.pop()!='{');

                if(b1||b2||b3){
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}

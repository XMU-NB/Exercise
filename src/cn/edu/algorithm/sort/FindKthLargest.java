package cn.edu.algorithm.sort;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 215. Kth Largest Element in an Array (Medium)
 *
 * Leetcode / 力扣
 *
 * Input: [3,2,1,5,6,4] and k = 2 Output: 5
 *
 * 题目描述：找到倒数第 k 个的元素。
 *
 * @author Administrator
 *
 */
public class FindKthLargest {
	// 1、数组排序好后查找
	public int findKthLargest1(int[] array, int k) {
		Arrays.sort(array);
		return array[array.length - k];
	}

	// 2、堆排序法，Queue可以重复添加元素
	public int findKthLargest2(int[] nums, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(); // 小顶堆
		for (int val : nums) {
			pq.add(val);
			if (pq.size() > k) // 维护堆的大小为 K
				pq.poll();
		}
		return pq.peek();
	}

	// 3、快速选择
	public int findKthLargest3(int[] nums, int k) {
		k = nums.length - k;
		int l = 0, h = nums.length - 1;
		while (l < h) {
			int j = partition(nums, l, h);
			if (j == k) {
				break;
			} else if (j < k) {
				l = j + 1;
			} else {
				h = j - 1;
			}
		}
		return nums[k];
	}
	//对数组l-h序号的数进行分割并返回分割位置
	private int partition(int[] a, int l, int h) {
		int i = l, j = h + 1;
		while (true) {
			while (a[++i] < a[l] && i < h) ;//找到比a[l]大的数
			while (a[--j] > a[l] && j > l) ;//找到比a[l]小的数
			if (i >= j) {
				break;
			}
			swap(a, i, j);
		}
		swap(a, l, j);//把最后找到的比a[l]小的的数与a[l]交换
		return j;
	}

	private void swap(int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
}

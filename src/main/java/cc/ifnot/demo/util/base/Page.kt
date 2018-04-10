/**
 * 2015-2016 龙果学院 (www.roncoo.com)
 */
package cc.ifnot.demo.util.base

import java.io.Serializable

/**
 * 数据分页组件
 *
 * @author wujing
 */
class Page<T> : Serializable {

    /**
     * 当前分页的数据集
     */
    var list: List<T>? = null

    /**
     * 总记录数
     */
    var totalCount: Int = 0

    /**
     * 总页数
     */
    var totalPage: Int = 0

    /**
     * 当前页
     */
    var pageCurrent: Int = 0

    /**
     * 每页记录数
     */
    var pageSize: Int = 0

    /**
     * 排序字段
     */
    var orderField: String? = null

    /**
     * 排序方式：asc or desc
     */
    var orderDirection: String? = null

    /**
     * 默认构造函数
     */
    constructor() {}

    /**
     * 构造函数
     *
     * @param totalCount
     * 总记录数
     * @param totalPage
     * 总页数
     * @param pageCurrent
     * @param pageSize
     * @param list
     */
    constructor(totalCount: Int, totalPage: Int, pageCurrent: Int, pageSize: Int, list: List<T>) {
        this.totalCount = totalCount
        this.totalPage = totalPage
        this.pageCurrent = pageCurrent
        this.pageSize = pageSize
        this.list = list
    }

    companion object {
        private const val serialVersionUID = -5764853545343945831L

        /**
         * 默认每页记录数(20)
         */
        val DEFAULT_PAGE_SIZE = 20

        /**
         * 最大每页记录数(1000)
         */
        val MAX_PAGE_SIZE = 1000
    }

}

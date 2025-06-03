package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.SysSalary;
import com.ruoyi.system.domain.vo.SysSalaryVo;
import com.ruoyi.system.service.ISysSalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 工资发放记录Controller
 *
 * @author Mredust
 * @date 2025-05-27
 */
@RestController
@RequestMapping("/system/salary")
public class SysSalaryController extends BaseController {
    @Autowired
    private ISysSalaryService sysSalaryService;
    
    /**
     * 查询工资发放记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:salary:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysSalaryVo sysSalary) {
        startPage();
        List<SysSalaryVo> list = sysSalaryService.selectSysSalaryList(sysSalary);
        return getDataTable(list);
    }
    
    /**
     * 导出工资发放记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:salary:export')")
    @Log(title = "工资发放记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysSalaryVo sysSalary) {
        List<SysSalaryVo> list = sysSalaryService.selectSysSalaryList(sysSalary);
        ExcelUtil<SysSalaryVo> util = new ExcelUtil<SysSalaryVo>(SysSalaryVo.class);
        util.exportExcel(response, list, "工资发放记录数据");
    }
    
    /**
     * 获取工资发放记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:salary:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(sysSalaryService.selectSysSalaryById(id));
    }
    
    /**
     * 新增工资发放记录
     */
    @PreAuthorize("@ss.hasPermi('system:salary:add')")
    @Log(title = "工资发放记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysSalaryVo sysSalary) {
        return toAjax(sysSalaryService.insertSysSalary(sysSalary));
    }
    
    /**
     * 修改工资发放记录
     */
    @PreAuthorize("@ss.hasPermi('system:salary:edit')")
    @Log(title = "工资发放记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysSalary sysSalary) {
        return toAjax(sysSalaryService.updateSysSalary(sysSalary));
    }
    
    /**
     * 删除工资发放记录
     */
    @PreAuthorize("@ss.hasPermi('system:salary:remove')")
    @Log(title = "工资发放记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(sysSalaryService.deleteSysSalaryByIds(ids));
    }
}

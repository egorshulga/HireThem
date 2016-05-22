package com.github.hirethem.action.admin.vacancies;

import com.github.hirethem.model.util.CsvGenerationUtil;
import com.github.hirethem.model.util.PdfGenerationUtil;
import com.github.hirethem.model.util.XlsGenerationUtil;
import com.opensymphony.xwork2.ActionSupport;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * Created by egorshulga on 22-May-16.
 */
public class DownloadVacanciesReportAction extends ActionSupport {

    private InputStream stream;

    public String downloadPdf() {
        try {
            stream = new ByteArrayInputStream(PdfGenerationUtil.getVacanciesReport().toByteArray());
            return SUCCESS;
        } catch (Exception e) {
            return INPUT;
        }
    }

    public String downloadCsv() {
        try {
            stream = new ByteArrayInputStream(CsvGenerationUtil.generateVacanciesInCSV().toByteArray());
            return SUCCESS;
        } catch (Exception e) {
            return INPUT;
        }
    }

    public String downloadXls() {
        try {
            stream = new ByteArrayInputStream(XlsGenerationUtil.generateVacanciesInXls().toByteArray());
            return SUCCESS;
        } catch (Exception e) {
            return INPUT;
        }
    }

    public InputStream getStream() {
        return stream;
    }

    public void setStream(InputStream stream) {
        this.stream = stream;
    }
}

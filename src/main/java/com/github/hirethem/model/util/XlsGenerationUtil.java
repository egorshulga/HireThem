package com.github.hirethem.model.util;

import com.github.hirethem.model.dao.ResumeDao;
import com.github.hirethem.model.dao.UserDao;
import com.github.hirethem.model.dao.VacancyDao;
import com.github.hirethem.model.entity.*;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.poi.hssf.usermodel.*;

import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * Created by Kirill on 03.05.2016.
 */
public class XlsGenerationUtil {

    public static ByteArrayOutputStream generateVacanciesInXls() throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("vacancy");
        HSSFCellStyle headerCellStyle = workbook.createCellStyle();
        HSSFFont boldFont = workbook.createFont();
        boldFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        headerCellStyle.setFont(boldFont);

        HSSFRow row = sheet.createRow(0);
        HSSFCell cell = row.createCell(0);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("№"));
        cell = row.createCell(1);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Employer"));
        cell = row.createCell(2);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Title"));
        cell = row.createCell(3);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Summary"));
        cell = row.createCell(4);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Salary"));
        cell = row.createCell(5);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Required skills"));
        cell = row.createCell(6);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Required experience"));
        VacancyDao vacancyDao = new VacancyDao();

        List<Vacancy> vacancyList = vacancyDao.getAllVacancies();
        for (int i = 0; i < vacancyList.size(); i++) {
            row = sheet.createRow(i + 1);

            Vacancy vacancy = vacancyList.get(i);
            cell = row.createCell(0);
            cell.setCellValue(i + 1);
            cell = row.createCell(1);
            cell.setCellValue(vacancy.getEmployer().getEmail());
            cell = row.createCell(2);
            cell.setCellValue(vacancy.getTitle());
            cell = row.createCell(3);
            cell.setCellValue(vacancy.getSummary() != null ? vacancy.getSummary() : "");
            cell = row.createCell(4);
            cell.setCellValue(vacancy.getSalary() != null ? vacancy.getSalary() : "");
            cell = row.createCell(5);
            cell.setCellValue(vacancy.getRequiredSkills() != null ? vacancy.getRequiredSkills() : "");
            cell = row.createCell(6);
            cell.setCellValue(vacancy.getRequiredExperience() != null ? vacancy.getRequiredExperience() : "");
        }


        HSSFCellStyle style = workbook.createCellStyle();
        style.setWrapText(true);
        sheet.autoSizeColumn(0);
        int[] columnWidths = new int[]{2, 20, 20, 30, 10, 50, 50};
        for (int i = 0; i < columnWidths.length; i++) {
            columnWidths[i] = columnWidths[i] * 256; //column width is measured in 1/256 characters sizes
        }
        for (int j = 0; j <= vacancyList.size(); j++) {
            row = sheet.getRow(j);
            row.setRowStyle(style);
            for (int i = 0; i < 7; i++) {
                row.getCell(i).setCellStyle(style);
                sheet.autoSizeColumn(i);
                sheet.setColumnWidth(i, columnWidths[i]);
            }
        }
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        workbook.write(stream);
        return stream;
    }

    public static ByteArrayOutputStream generateResumesInXls() throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("resumes");
        HSSFCellStyle headerCellStyle = workbook.createCellStyle();
        HSSFFont boldFont = workbook.createFont();
        boldFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        headerCellStyle.setFont(boldFont);

        HSSFRow row = sheet.createRow(0);
        HSSFCell cell = row.createCell(0);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("№"));
        cell = row.createCell(1);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Employee"));
        cell = row.createCell(2);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Summary"));
        cell = row.createCell(3);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Skills"));
        cell = row.createCell(4);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Education"));
        cell = row.createCell(5);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Work experience"));

        ResumeDao resumeDao = new ResumeDao();

        List<Resume> resumeList = resumeDao.getAllResumes();

        for (int i = 0; i < resumeList.size(); i++) {
            row = sheet.createRow(i + 1);

            Resume resume = resumeList.get(i);
            cell = row.createCell(0);
            cell.setCellValue(i + 1);
            cell = row.createCell(1);
            cell.setCellValue(resume.getEmployee().getEmail());
            cell = row.createCell(2);
            cell.setCellValue(resume.getSummary());
            cell = row.createCell(3);
            cell.setCellValue(resume.getSkills() != null ? resume.getSkills() : "");
            cell = row.createCell(4);
            Set<Education> educationList = resume.getEducations();
            String newTemp = "";
            if (educationList.isEmpty()) {
                newTemp = "";
            } else {
                for (Education temp : educationList) {
                    newTemp = temp.getUniversity() + " in " + (temp.getSpecialty() != null ? temp.getSpecialty() : "");
                }
            }
            cell.setCellValue(newTemp);
            cell = row.createCell(5);
            Set<WorkExperience> workExperiencesSet = resume.getWorkExperiences();
            if (workExperiencesSet.isEmpty()) {
                newTemp = "";
            } else {
                for (WorkExperience temp : workExperiencesSet) {
                    newTemp = temp.getCompanyName() + " as " + temp.getPosition();
                }
            }
            cell.setCellValue(newTemp);
        }


        HSSFCellStyle style = workbook.createCellStyle();
        style.setWrapText(true);
        sheet.autoSizeColumn(0);
        int[] columnWidths = new int[]{2, 20, 50, 30, 40, 40};
        for (int i = 0; i < columnWidths.length; i++) {
            columnWidths[i] = columnWidths[i] * 256; //column width is measured in 1/256 characters sizes
        }
        for (int j = 0; j <= resumeList.size(); j++) {
            row = sheet.getRow(j);
            row.setRowStyle(style);
            for (int i = 0; i < 6; i++) {
                row.getCell(i).setCellStyle(style);
                sheet.autoSizeColumn(i);
                sheet.setColumnWidth(i, columnWidths[i]);
            }
        }

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        workbook.write(stream);
        return stream;
    }

    public static ByteArrayOutputStream generateUsersInXls() throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("users");
        HSSFCellStyle headerCellStyle = workbook.createCellStyle();
        HSSFFont boldFont = workbook.createFont();
        boldFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        headerCellStyle.setFont(boldFont);

        HSSFRow row = sheet.createRow(0);
        HSSFCell cell = row.createCell(0);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("№"));
        cell = row.createCell(1);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("E-mail"));
        cell = row.createCell(2);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("User type"));
        cell = row.createCell(3);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Name"));
        cell = row.createCell(4);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Surname"));
        cell = row.createCell(5);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("About"));
        cell = row.createCell(6);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Contact info"));
        cell = row.createCell(7);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Is Admin"));
        UserDao userDao = new UserDao();

        List<User> userList = userDao.getAllUsers();
        for (int i = 0; i < userList.size(); i++) {
            row = sheet.createRow(i + 1);

            User user = userList.get(i);
            cell = row.createCell(0);
            cell.setCellValue(i + 1);
            cell = row.createCell(1);
            cell.setCellValue(user.getEmail());
            cell = row.createCell(2);
            cell.setCellValue(user.getUserType().toString());
            cell = row.createCell(3);
            cell.setCellValue(user.getName());
            cell = row.createCell(4);
            cell.setCellValue(user.getSurname());
            cell = row.createCell(5);
            cell.setCellValue(user.getAbout() != null ? user.getAbout() : "");
            cell = row.createCell(6);
            cell.setCellValue(user.getContactInfo() != null ? user.getContactInfo() : "");
            cell = row.createCell(7);
            cell.setCellValue(user.getIsAdmin());
        }


        HSSFCellStyle style = workbook.createCellStyle();
        style.setWrapText(true);
        sheet.autoSizeColumn(0);
        int[] columnWidths = new int[]{2, 30, 15, 15, 15, 40, 50, 10};
        for (int i = 0; i < columnWidths.length; i++) {
            columnWidths[i] = columnWidths[i] * 256; //column width is measured in 1/256 characters sizes
        }
        for (int j = 0; j <= userList.size(); j++) {
            row = sheet.getRow(j);
            row.setRowStyle(style);
            for (int i = 0; i < 8; i++) {
                row.getCell(i).setCellStyle(style);
                sheet.autoSizeColumn(i);
                sheet.setColumnWidth(i, columnWidths[i]);
            }
        }

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        workbook.write(stream);
        return stream;
    }

    public static ByteArrayOutputStream generateResumeInXls(int resumeId) throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("resume");
        HSSFCellStyle headerCellStyle = workbook.createCellStyle();
        HSSFFont boldFont = workbook.createFont();
        boldFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        headerCellStyle.setFont(boldFont);

        HSSFRow row = sheet.createRow(0);
        HSSFCell cell;
        cell = row.createCell(0);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Employee"));
        cell = row.createCell(1);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Summary"));
        cell = row.createCell(2);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Skills"));
        cell = row.createCell(3);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Education"));
        cell = row.createCell(4);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Work experience"));
        cell = row.createCell(5);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Description"));
        cell = row.createCell(6);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Interests"));

        ResumeDao resumeDao = new ResumeDao();

        Resume resume = resumeDao.getResume(resumeId);

        row = sheet.createRow(1);

        cell = row.createCell(0);
        cell.setCellValue(resume.getEmployee().getEmail());
        cell = row.createCell(1);
        cell.setCellValue(resume.getSummary());
        cell = row.createCell(2);
        cell.setCellValue(resume.getSkills() != null ? resume.getSkills() : "");
        cell = row.createCell(3);
        Set<Education> educationList = resume.getEducations();
        String newTemp = "";
        for (Education temp : educationList) {
            newTemp = temp.getUniversity() + " in " + (temp.getSpecialty() != null ? temp.getSpecialty() : "");
        }
        cell.setCellValue(newTemp);
        cell = row.createCell(4);
        Set<WorkExperience> workExperiencesSet = resume.getWorkExperiences();
        newTemp = "";
        for (WorkExperience temp : workExperiencesSet) {
            newTemp = temp.getCompanyName() + " as " + temp.getPosition();
        }
        cell.setCellValue(newTemp);
        cell = row.createCell(5);
        cell.setCellValue(resume.getDescription());
        cell = row.createCell(6);
        cell.setCellValue(resume.getInterests());


        HSSFCellStyle style = workbook.createCellStyle();
        style.setWrapText(true);
        sheet.autoSizeColumn(0);
        int[] columnWidths = new int[]{20, 35, 25, 25, 25, 25, 25};
        for (int i = 0; i < columnWidths.length; i++) {
            columnWidths[i] = columnWidths[i] * 256; //column width is measured in 1/256 characters sizes
        }
        for (int j = 0; j <= 1; j++) {
            row = sheet.getRow(j);
            row.setRowStyle(style);
            for (int i = 0; i < 7; i++) {
                row.getCell(i).setCellStyle(style);
                sheet.autoSizeColumn(i);
                sheet.setColumnWidth(i, columnWidths[i]);
            }
        }

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        workbook.write(stream);
        return stream;
    }

    public static ByteArrayOutputStream generateVacancyInXls(int vacancyId) throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("vacancy");
        HSSFCellStyle headerCellStyle = workbook.createCellStyle();
        HSSFFont boldFont = workbook.createFont();
        boldFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        headerCellStyle.setFont(boldFont);

        HSSFRow row = sheet.createRow(0);
        HSSFCell cell;
        cell = row.createCell(0);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Employer"));
        cell = row.createCell(1);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Title"));
        cell = row.createCell(2);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Summary"));
        cell = row.createCell(3);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Salary"));
        cell = row.createCell(4);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Required Experience"));
        cell = row.createCell(5);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Description"));
        cell = row.createCell(6);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Skills"));

        VacancyDao vacancyDao = new VacancyDao();

        Vacancy vacancy = vacancyDao.getVacancy(vacancyId);

        row = sheet.createRow(1);

        cell = row.createCell(0);
        cell.setCellValue(vacancy.getEmployer().getEmail());
        cell = row.createCell(1);
        cell.setCellValue(vacancy.getTitle());
        cell = row.createCell(2);
        cell.setCellValue(vacancy.getSummary());
        cell = row.createCell(3);
        cell.setCellValue(vacancy.getSalary());
        cell = row.createCell(4);
        cell.setCellValue(vacancy.getRequiredExperience());
        cell = row.createCell(5);
        cell.setCellValue(vacancy.getDescription() != null ? vacancy.getDescription() : "");
        cell = row.createCell(6);
        cell.setCellValue(vacancy.getRequiredSkills() != null ? vacancy.getRequiredSkills() : "");


        HSSFCellStyle style = workbook.createCellStyle();
        style.setWrapText(true);
        sheet.autoSizeColumn(0);
        int[] columnWidths = new int[]{20, 20, 20, 10, 35, 35, 35};
        for (int i = 0; i < columnWidths.length; i++) {
            columnWidths[i] = columnWidths[i] * 256; //column width is measured in 1/256 characters sizes
        }
        for (int j = 0; j <= 1; j++) {
            row = sheet.getRow(j);
            row.setRowStyle(style);
            for (int i = 0; i < 7; i++) {
                row.getCell(i).setCellStyle(style);
                sheet.autoSizeColumn(i);
                sheet.setColumnWidth(i, columnWidths[i]);
            }
        }

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        workbook.write(stream);
        return stream;
    }

}

package com.github.hirethem.model.util;

import com.github.hirethem.model.entity.Education;
import com.github.hirethem.model.entity.Resume;
import com.github.hirethem.model.entity.User;
import com.github.hirethem.model.service.*;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import org.apache.commons.lang3.StringUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created by egorshulga on 02-May-16.
 */
public class PdfGenerationUtil {

    private UserService userService = new UserService();
    private VacancyService vacancyService = new VacancyService();
    private ResumeService resumeService = new ResumeService();
    private EducationsService educationsService = new EducationsService();
    private WorkExperienceService workExperienceService = new WorkExperienceService();

    private static int FONT_SIZE_SMALL = 10;
    private static int FONT_SIZE_NORMAL = 14;
    private static int FONT_SIZE_BIG = 20;
    private static int VERTICAL_SPACE_TINY = 5;
    private static int VERTICAL_SPACE_SMALL = 20;
    private static int VERTICAL_SPACE_MEDIUM = 40;
    private static int VERTICAL_SPACE_BIG = 80;
    private static int HEIGHT_SMALL_LINE = FONT_SIZE_SMALL + 1;
    private static int HEIGHT_NORMAL_LINE = FONT_SIZE_NORMAL + VERTICAL_SPACE_TINY + 2;
    private static int HEIGHT_BIG_LINE = FONT_SIZE_NORMAL + VERTICAL_SPACE_TINY;

    private static final String TEMPLATE = "/templates/template.jpg";
    private static final String FONT = "/fonts/times.ttf";

    private static Font smallFont = FontFactory.getFont(FONT, BaseFont.IDENTITY_H, BaseFont.EMBEDDED, FONT_SIZE_SMALL);
    private static Font normalFont = FontFactory.getFont(FONT, BaseFont.IDENTITY_H, BaseFont.EMBEDDED, FONT_SIZE_NORMAL);
    private static Font normalBoldFont = FontFactory.getFont(FONT, BaseFont.IDENTITY_H, BaseFont.EMBEDDED, FONT_SIZE_NORMAL, Font.BOLD);
    private static Font bigFont = FontFactory.getFont(FONT, BaseFont.IDENTITY_H, BaseFont.EMBEDDED, FONT_SIZE_BIG, Font.BOLD);
    private static Font bigBoldFont = FontFactory.getFont(FONT, BaseFont.IDENTITY_H, BaseFont.EMBEDDED, FONT_SIZE_BIG + 2, Font.BOLD);

    synchronized static public ByteArrayOutputStream createResumeDocument(Resume resume) throws DocumentException, IOException {

        Document document = new Document(PageSize.A4);
        ByteArrayOutputStream stream;
        User user = resume.getEmployee();

        stream = new ByteArrayOutputStream();
        PdfWriter writer = PdfWriter.getInstance(document, stream);
        writer.setEncryption(null, null, PdfWriter.ALLOW_PRINTING, PdfWriter.STANDARD_ENCRYPTION_128);
        writer.createXmpMetadata();
        document.open();

        PdfContentByte canvas = writer.getDirectContentUnder();
        Image image = Image.getInstance(ByteArrayOutputStream.class.getResource(TEMPLATE));
        image.scaleAbsolute(PageSize.A4);
        image.setAbsolutePosition(0, 0);
        canvas.addImage(image);

        Paragraph paragraph = new Paragraph();
        paragraph.setFont(FontFactory.getFont(FontFactory.TIMES_BOLD, FONT_SIZE_BIG + 4));
        paragraph.setSpacingAfter(VERTICAL_SPACE_TINY);
        paragraph.add(new Chunk("Resume"));
        document.add(paragraph);
        document.add(new LineSeparator());

        if (user.getAvatar() != null) {
            image = Image.getInstance(user.getAvatar());
            image.scaleToFit(120, 160);
            image.setAlignment(Element.ALIGN_RIGHT | Image.TEXTWRAP | Element.ALIGN_TOP);
            document.add(image);
        }

        paragraph = new Paragraph(" ");
        paragraph.setSpacingAfter(VERTICAL_SPACE_SMALL);
        document.add(paragraph);

        paragraph = new Paragraph();
        paragraph.setFont(bigBoldFont);
        paragraph.setSpacingAfter(VERTICAL_SPACE_SMALL);
        paragraph.add(new Chunk(user.getName() + " " + user.getSurname()));
        document.add(paragraph);

        if (user.getContactInfo() != null) {
            paragraph = new Paragraph();
            paragraph.setFont(normalFont);
            paragraph.setSpacingAfter(VERTICAL_SPACE_SMALL);
            paragraph.add(new Chunk(user.getContactInfo()));
            document.add(paragraph);
        }

        document.add(new LineSeparator());
        paragraph = new Paragraph();
        paragraph.setFont(bigFont);
        paragraph.setSpacingAfter(VERTICAL_SPACE_TINY);
        paragraph.setSpacingBefore(VERTICAL_SPACE_TINY);
        paragraph.add(new Chunk("Summary"));
        document.add(paragraph);
        document.add(new LineSeparator());

        paragraph = new Paragraph();
        paragraph.setFont(normalFont);
        paragraph.setSpacingBefore(VERTICAL_SPACE_TINY);
        paragraph.setSpacingAfter(VERTICAL_SPACE_SMALL);
        paragraph.add(new Chunk(resume.getSummary()));
        document.add(paragraph);

        if (StringUtils.isNotBlank(resume.getDescription())) {
            document.add(new LineSeparator());
            paragraph = new Paragraph();
            paragraph.setFont(bigFont);
            paragraph.setSpacingAfter(VERTICAL_SPACE_TINY);
            paragraph.setSpacingBefore(VERTICAL_SPACE_TINY);
            paragraph.add(new Chunk("Description"));
            document.add(paragraph);
            document.add(new LineSeparator());

            paragraph = new Paragraph();
            paragraph.setFont(normalFont);
            paragraph.setSpacingBefore(VERTICAL_SPACE_TINY);
            paragraph.setSpacingAfter(VERTICAL_SPACE_SMALL);
            paragraph.add(new Chunk(resume.getDescription()));
            document.add(paragraph);
        }

        if (StringUtils.isNotBlank(resume.getSkills())) {
            document.add(new LineSeparator());
            paragraph = new Paragraph();
            paragraph.setFont(bigFont);
            paragraph.setSpacingAfter(VERTICAL_SPACE_TINY);
            paragraph.setSpacingBefore(VERTICAL_SPACE_TINY);
            paragraph.add(new Chunk("Skills"));
            document.add(paragraph);
            document.add(new LineSeparator());

            paragraph = new Paragraph();
            paragraph.setFont(normalFont);
            paragraph.setSpacingBefore(VERTICAL_SPACE_TINY);
            paragraph.setSpacingAfter(VERTICAL_SPACE_SMALL);
            paragraph.add(new Chunk(resume.getSkills()));
            document.add(paragraph);
        }

        if (StringUtils.isNotBlank(resume.getInterests())) {
            document.add(new LineSeparator());
            paragraph = new Paragraph();
            paragraph.setFont(bigFont);
            paragraph.setSpacingAfter(VERTICAL_SPACE_TINY);
            paragraph.setSpacingBefore(VERTICAL_SPACE_TINY);
            paragraph.add(new Chunk("Interests"));
            document.add(paragraph);
            document.add(new LineSeparator());

            paragraph = new Paragraph();
            paragraph.setFont(normalFont);
            paragraph.setSpacingBefore(VERTICAL_SPACE_TINY);
            paragraph.setSpacingAfter(VERTICAL_SPACE_SMALL);
            paragraph.add(new Chunk(resume.getInterests()));
            document.add(paragraph);
        }

        if (!resume.getEducations().isEmpty()) {
            document.add(new LineSeparator());
            paragraph = new Paragraph();
            paragraph.setFont(bigFont);
            paragraph.setSpacingAfter(VERTICAL_SPACE_TINY);
            paragraph.setSpacingBefore(VERTICAL_SPACE_TINY);
            paragraph.add(new Chunk("Education"));
            document.add(paragraph);
            document.add(new LineSeparator());

            Iterator<Education> educationsIterator = resume.getEducations().iterator();
            while (educationsIterator.hasNext()) {
                Education education = educationsIterator.next();

                paragraph = new Paragraph();
                paragraph.setFont(normalBoldFont);
                paragraph.setSpacingBefore(VERTICAL_SPACE_TINY);
                paragraph.add(new Chunk(education.getUniversity()));
                document.add(paragraph);

                paragraph = new Paragraph();
                paragraph.setFont(normalFont);
                paragraph.add(new Chunk(StringUtils.capitalize(education.getDegree()) + " in " +
                        education.getSpecialty() + " field."));
                document.add(paragraph);

                paragraph = new Paragraph();
                paragraph.setFont(normalFont);
                paragraph.add(new Chunk("From " + education.getStartDate() + " to " + education.getEndDate() + "."));
                if (StringUtils.isBlank(education.getDescription())) {
                    paragraph.setSpacingAfter(VERTICAL_SPACE_SMALL);
                }
                document.add(paragraph);

                if (StringUtils.isNotBlank(education.getDescription())) {
                    paragraph = new Paragraph();
                    paragraph.setFont(normalFont);
                    paragraph.setSpacingAfter(VERTICAL_SPACE_SMALL);
                    paragraph.add(new Chunk(education.getDescription()));
                    document.add(paragraph);
                }
            }
        }


        //work experiences


        if (StringUtils.isNotBlank(resume.getReferences())) {
            document.add(new LineSeparator());
            paragraph = new Paragraph();
            paragraph.setFont(bigFont);
            paragraph.setSpacingAfter(VERTICAL_SPACE_TINY);
            paragraph.setSpacingBefore(VERTICAL_SPACE_TINY);
            paragraph.add(new Chunk("References"));
            document.add(paragraph);
            document.add(new LineSeparator());

            paragraph = new Paragraph();
            paragraph.setFont(normalFont);
            paragraph.setSpacingBefore(VERTICAL_SPACE_TINY);
            paragraph.setSpacingAfter(VERTICAL_SPACE_SMALL);
            paragraph.add(new Chunk(resume.getReferences()));
            document.add(paragraph);
        }

        document.add(new LineSeparator());
        document.close();
        return stream;
    }

}

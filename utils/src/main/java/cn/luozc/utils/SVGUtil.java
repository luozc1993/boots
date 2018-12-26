package cn.luozc.utils;


public class SVGUtil {

//    /**
//     * 将svg字符串转换为png
//     *
//     * @param svgCode svg代码
//     * @param pngFilePath 保存的路径
//     * @throws IOException io错误
//     */
//    public static void convertToPng(String svgCode, String pngFilePath) throws Exception{
//
//        File file = new File(pngFilePath);
//
//        FileOutputStream outputStream = null;
//        try {
//            file.createNewFile();
//            outputStream = new FileOutputStream(file);
//            convertToPng(svgCode, outputStream);
//        } finally {
//            if (outputStream != null) {
//                try {
//                    outputStream.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//
//    /**
//     * 将svgCode转换成png文件，直接输出到流中
//     *
//     * @param svgCode svg代码
//     * @param outputStream 输出流
//     * @throws TranscoderException 异常
//     * @throws IOException io异常
//     */
//    public static void convertToPng(String svgCode, OutputStream outputStream)
//            throws TranscoderException, IOException {
//        try {
//            byte[] bytes = svgCode.getBytes("utf-8");
//            PNGTranscoder t = new PNGTranscoder();
//            TranscoderInput input = new TranscoderInput(new ByteArrayInputStream(bytes));
//            TranscoderOutput output = new TranscoderOutput(outputStream);
//            t.transcode(input, output);
//            outputStream.flush();
//        } finally {
//            if (outputStream != null) {
//                try {
//                    outputStream.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }

}

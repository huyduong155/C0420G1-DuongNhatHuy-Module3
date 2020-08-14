package controller;

import bo.*;
import model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeServlet",urlPatterns = "/HomeServlet")
public class HomeServlet extends HttpServlet {
    private IKhachHangBo iKhachHangBo = new KhachHangBo();
    private IDichVuBo iDichVuBo = new DichVuBo();
    private INhanVienBo iNhanVienBo = new NhanVienBo();
    private IHopDongBo iHopDongBo = new HopDongBo();
    private IHopDongChiTietBo iHopDongChiTietBo = new HopDongChiTietBo();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createService(request,response);
                break;
            case "createContract":
                createContract(request,response);
                break;
            case "createContractDetail":
                createContractDetail(request,response);
                break;
        }
    }

    private void createContractDetail(HttpServletRequest request, HttpServletResponse response) {
        int so_luong = Integer.parseInt(request.getParameter("quantily"));
        int id_hop_dong = Integer.parseInt(request.getParameter("ContractId"));
        int id_dich_vu_di_kem = Integer.parseInt(request.getParameter("ServiceId"));
        Hop_dong_chi_tiet hopDongChiTiet = new Hop_dong_chi_tiet(so_luong,id_hop_dong,id_dich_vu_di_kem);
        iHopDongChiTietBo.insertHopDongChiTiet(hopDongChiTiet);
        try {
            response.sendRedirect("/HomeServlet");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createContract(HttpServletRequest request, HttpServletResponse response) {
        String ngay_lam_hop_dong = request.getParameter("startDate");
        String ngay_ket_thuc = request.getParameter("endDate");
        int tien_dat_coc = Integer.parseInt(request.getParameter("deposic"));
        int tong_tien = Integer.parseInt(request.getParameter("people"));
        int id_nhan_vien = Integer.parseInt(request.getParameter("EmployeeId"));
        int id_khach_hang = Integer.parseInt(request.getParameter("CustomerId"));
        int id_dich_vu = Integer.parseInt(request.getParameter("ServiceId"));
        Hop_dong hop_dong = new Hop_dong(ngay_lam_hop_dong,ngay_ket_thuc,tien_dat_coc,tong_tien,id_nhan_vien,id_khach_hang,id_dich_vu);
        iHopDongBo.insertHopDong(hop_dong);
        try {
            response.sendRedirect("/HomeServlet");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createService(HttpServletRequest request, HttpServletResponse response) {
         String ten_dich_vu = request.getParameter("Name");
         int dien_tich = Integer.parseInt(request.getParameter("area"));
         int so_tang = Integer.parseInt(request.getParameter("floor"));
         String so_nguoi = request.getParameter("people");
         String chi_phi_thue = request.getParameter("cost");
         String trang_thai = request.getParameter("status");
         int id_kieu_thue = Integer.parseInt(request.getParameter("RentTypeId"));
         int id_loai_dich_vu = Integer.parseInt(request.getParameter("SerTypeId"));
        Dich_vu dichVu = new Dich_vu(ten_dich_vu,dien_tich,so_tang,so_nguoi,chi_phi_thue,trang_thai,id_kieu_thue,id_loai_dich_vu);
        iDichVuBo.insertDichVu(dichVu);
        try {
            response.sendRedirect("/HomeServlet");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            default:
                listHome(request,response);
        }
    }

    private void listHome(HttpServletRequest request, HttpServletResponse response) {
        List<DTO_khach_hang_dich_vu> dtoKhachHangDichVuList = iKhachHangBo.selectAllKhachHangDichVu();
        request.setAttribute("listCusService",dtoKhachHangDichVuList);
        List<Loai_khach> loaiKhachList= iKhachHangBo.selectAllLoaiKhach();
        request.setAttribute("listCusType",loaiKhachList);
        List<Kieu_thue> kieuThueList = iDichVuBo.selectAllKieuThue();
        request.setAttribute("listRentType",kieuThueList);
        List<Loai_dich_vu> loaiDichVuList = iDichVuBo.selectAllLoaiDichVu();
        request.setAttribute("listSerType",loaiDichVuList);
        List<Vi_tri> viTriList = iNhanVienBo.selectAllViTri();
        request.setAttribute("listPosition",viTriList);
        List<Trinh_do> trinhDoList = iNhanVienBo.selectAllTrinhDo();
        request.setAttribute("listEducation",trinhDoList);
        List<Bo_phan> boPhanList = iNhanVienBo.selectAllBoPhan();
        request.setAttribute("listDivision",boPhanList);
        List<Khach_hang> khachHangList = iHopDongBo.selectKhachHang();
        request.setAttribute("listCus",khachHangList);
        List<Nhan_vien> nhanVienList = iHopDongBo.selectNhanVien();
        request.setAttribute("listEmp",nhanVienList);
        List<Dich_vu> dichVuList = iHopDongBo.selectDichVu();
        request.setAttribute("listSer",dichVuList);
        List<Hop_dong> hopDongList = iHopDongChiTietBo.selectHopDong();
        request.setAttribute("listContract",hopDongList);
        List<Dich_vu_di_kem> dichVuDiKemList = iHopDongChiTietBo.selectDichVuDiKem();
        request.setAttribute("listServiceAttach",dichVuDiKemList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("furama/home.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

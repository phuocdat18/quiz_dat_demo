class AppBase {

    static DOMAIN_SERVER = 'http://localhost:8090'



    static API_SERVER = this.DOMAIN_SERVER + '/api'


    static API_PRODUCT = this.API_SERVER + '/products'
    static API_USER = this.API_SERVER + '/users'

    static API_QUIZ = this.API_SERVER + '/quiz'
    static API_QUESTION = this.API_SERVER + 'question'






    static API_AUTH = this.API_SERVER + "/auth";
    static API_LOGIN = this.API_AUTH + "/login";
    static API_REGISTER = this.API_AUTH + "/register";

    static API_USERS = this.API_SERVER + '/users'
    static API_UPDATE_USER = this.API_USERS + '/update'
    static API_ROLE = this.API_USERS + '/roles'

    static AlertMessageEn = class {
        static SUCCESS_CREATED = "Successful data generation !";
        static SUCCESS_UPDATED = "Cập nhật thông tin thành công !";
        static SUCCESS_DELETED = "Delete product successful !";
        static SUCCESS_PAYMENT = "Đã thanh toán thành công!"


        static ERROR_400 = "The operation failed, please check the data again.";
        static ERROR_401 = "Unauthorized - Your access token has expired or is not valid.";
        static ERROR_403 = "Forbidden - You are not authorized to access this resource.";
        static ERROR_404 = "Not Found - The resource has been removed or does not exist";
        static ERROR_500 = "Internal Server Error - The server system is having problems or cannot be accessed.";

        static ERROR_LOADING_PROVINCE = "Loading list of provinces - cities failed !";
        static ERROR_LOADING_DISTRICT = "Loading list of district - ward failed !"
        static ERROR_LOADING_WARD = "Loading list of wards - communes - towns failed !";
        static ERROR_NUMBER_QUANTITY = "Số lượng mua vượt quá số lượng đang có!"
        static ERROR_FIND_PRODUCT = "Không tìm thấy sản phẩm!"
    }

    static AlertMessageVi = class {
        static ERROR_400 = "Thao tác không thành công, vui lòng kiểm tra lại dữ liệu.";
        static ERROR_401 = "Unauthorized - Access Token của bạn hết hạn hoặc không hợp lệ.";
        static ERROR_403 = "Forbidden - Bạn không được quyền truy cập tài nguyên này.";
        static ERROR_404 = "Not Found - Tài nguyên này đã bị xóa hoặc không tồn tại";
        static ERROR_500 = "Internal Server Error - Hệ thống Server đang có vấn đề hoặc không truy cập được.";

        static ERROR_LOADING_PROVINCE = "Tải danh sách tỉnh - thành phố không thành công !";
        static ERROR_LOADING_DISTRICT = "Tải danh sách quận - phường - huyện không thành công !";
        static ERROR_LOADING_WARD = "Tải danh sách phường - xã - thị trấn không thành công !";
    }

    static SweetAlert = class {
        static showDeleteConfirmDialog() {
            return Swal.fire({
                icon: 'warning',
                text: 'Are you sure to delete the selected product ?',
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#d33',
                confirmButtonText: 'Yes, please delete this client !',
                cancelButtonText: 'Cancel',
            })
        }
         static showRestoreConfirmDialog() {
            return Swal.fire({
                icon: 'warning',
                text: 'You have to restore this account ?',
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#d33',
                confirmButtonText: 'Yes !',
                cancelButtonText: 'Cancel',
            })
        }


        static showSuccessAlert(t) {
            Swal.fire({
                icon: 'success',
                title: t,
                position: 'top-end',
                showConfirmButton: false,
                timer: 1500
            })
        }

        static showErrorAlert(t) {
            Swal.fire({
                icon: 'error',
                title: 'Warning',
                text: t,
            })
        }

        static showError401() {
            Swal.fire({
                icon: 'error',
                title: 'Access Denied',
                text: 'Invalid credentials!',
            })
        }

        static showError403() {
            Swal.fire({
                icon: 'error',
                title: 'Access Denied',
                text: 'You are not authorized to perform this function!',
            })
        }
    }

    static IziToast = class {
        static showSuccessAlert(m) {
            iziToast.success({
                title: 'OK',
                position: 'topRight',
                timeout: 2500,
                message: m
            });
        }

        static showErrorAlert(m) {
            iziToast.error({
                title: 'Error',
                position: 'topRight',
                timeout: 2500,
                message: m
            });
        }
    }

    static Notify = class {
        static showSuccessAlert(m) {
            $.notify(m, "success");
        }

        static showErrorAlert(m) {
            $.notify(m, "error");
        }
    }

    static formatNumber() {
        $(".num-space").number(true, 0, ',', ' ')
        $(".num-point").number(true, 0, ',', '.');
        $(".num-comma").number(true, 0, ',', ',');
    }

    static formatNumberSpace(x) {
        if (x == null) {
            return x;
        }
        return x.toString().replace(/ /g, "").replace(/\B(?=(\d{3})+(?!\d))/g, " ");
    }

    static removeFormatNumberSpace(x) {
        if (x == null) {
            return x;
        }
        return x.toString().replace(/ /g, "")
    }

    static formatTooltip() {
        $('[data-toggle="tooltip"]').tooltip();
    }
}

class quiz {
    constructor(id, content, question, quizzes) {
        this.id = id;
        this.content = content;
        this.question = question;
        this.quizzes = quizzes;
    }

}
class question {
    constructor(id,content,type,quizQ,answers) {
        this.id = id;
        this.content = content;
        this.type = type;
        this.quizQ = quizQ;
        this.answers = answers;
    }
}

class answer {
    constructor(id, content, question, status) {
        this.id = id;
        this.content = content;
        this.question = question;
        this.status = status;
    }
}

class User {
    constructor(id,fullname,email,phone,deleted) {
        this.id = id;
        this.fullname = fullname;
        this.email = email;
        this.phone = phone;
        this.deleted = deleted;
    }
}

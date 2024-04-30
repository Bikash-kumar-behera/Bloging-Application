import { NextRequest, NextResponse } from "next/server";
import axios from "axios";
import { getDataFromToken } from "@/helpers/getDataFromToken";

export async function POST(request) {
    try {
        const userId = await getDataFromToken(request);
        const reqBody = await request.json();
        const { desc, id } = reqBody;
        const comment = {
            commentText: desc,
            commenterId: userId,
        };
        const url = process.env.BACKEND_URL + `/post/${id}/comment`;
        const posts = await axios.post(url, comment);

        return NextResponse.json({
            message: "Comment Created successful",
            data: posts.data.data,
        });
    } catch (error) {
        return NextResponse.json({ error: error.message }, { status: 400 });
    }
}
